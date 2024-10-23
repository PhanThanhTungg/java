    package server;

    import java.net.DatagramPacket;
    import java.net.DatagramSocket;
    import java.net.InetAddress;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;

    public class Server {
        private static final int PORT = 8000;

        private static Connection connect() {
            try {
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/thuchanh2", "root", "123456");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void main(String[] args) {
            try {
                DatagramSocket socket = new DatagramSocket(PORT);
                System.out.println("Server is running on port " + PORT + "...");
                while (true) {
                    byte[] buffer = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    String message = new String(packet.getData(), 0, packet.getLength());
                    handle(message, packet.getAddress(), packet.getPort());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void handle(String message, InetAddress clientAddress, int clientPort) {
            String[] parts = message.split(":");
            String command = parts[0];
            System.out.println("Received message from client: " + message);
            String response = "";

            switch (command) {
                case "SEARCHNAME":
                    response = searchByName(parts[1]);
                    break;
                case "SEARCHGPA":
                    response = searchByGPA(parts[1], parts[2]);
                    break;
                case "UPDATE":
                    updateStudent(parts);
                    response = "Student updated successfully.";
                    break;
                default:
                    response = "Invalid command.";
            }

            sendResponse(response, clientAddress, clientPort);
        }
        
        private static String searchByName(String name) {
            StringBuilder result = new StringBuilder();
            try (Connection conn = connect()) {
                String sql = "SELECT * FROM student WHERE hoTen LIKE ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" + name + "%");
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    appendStudentInfo(result, rs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result.toString();
        }

        private static String searchByGPA(String gpaMin, String gpaMax) {
            StringBuilder result = new StringBuilder();
            try (Connection conn = connect()) {
                String sql = "SELECT * FROM student WHERE GPA BETWEEN ? AND ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setFloat(1, gpaMin.isEmpty() ? 0 : Float.parseFloat(gpaMin));
                stmt.setFloat(2, gpaMax.isEmpty() ? Float.MAX_VALUE : Float.parseFloat(gpaMax));
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    appendStudentInfo(result, rs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result.toString();
        }

        private static void appendStudentInfo(StringBuilder result, ResultSet rs) throws Exception {
            result.append(rs.getInt("idSV")).append(",")
                  .append(rs.getString("maSV")).append(",")
                  .append(rs.getString("hoTen")).append(",")
                  .append(rs.getInt("namSinh")).append(",")
                  .append(rs.getString("queQuan")).append(",")
                  .append(rs.getFloat("GPA")).append(";");
        }

        private static void sendResponse(String response, InetAddress clientAddress, int clientPort) {
            try {
                byte[] buffer = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
                DatagramSocket socket = new DatagramSocket();
                socket.send(responsePacket);
                System.out.println("Response sent to client.");
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void updateStudent(String[] parts) {
            try (Connection conn = connect()) {
                if (conn == null) {
                    System.out.println("Failed to connect to the database.");
                    return;
                }

                String sql = "UPDATE student SET maSV = ?, hoTen = ?, namSinh = ?, queQuan = ?, GPA = ? WHERE idSV = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, parts[2]);
                stmt.setString(2, parts[3]);
                stmt.setInt(3, Integer.parseInt(parts[4]));
                stmt.setString(4, parts[5]);
                stmt.setFloat(5, Float.parseFloat(parts[6]));
                stmt.setInt(6, Integer.parseInt(parts[1]));

                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Student " + parts[1] + " updated successfully.");
                } else {
                    System.out.println("No ID " + parts[1] + ". Update failed.");
                }
            } catch (Exception e) {
                System.out.println("update error: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }
