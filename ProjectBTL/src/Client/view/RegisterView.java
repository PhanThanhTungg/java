
package Client.view;

import Client.controller.ClientCtrl;
import com.sun.net.httpserver.Request;
import javax.swing.JOptionPane;
import model.User;
import model.UserRequest;

public class RegisterView extends javax.swing.JFrame {
    User user;
    ClientCtrl clientCtrl;
    UserRequest userRequest;
    
    public RegisterView() {
        initComponents();
        clientCtrl = new ClientCtrl();
    }
    
    private int check(){
        if(taikhoanTextField.getText().equals("")){
            JOptionPane.showMessageDialog(this, "vui lòng nhập tài khoản");
            return 0;
        }
        else if(String.valueOf(matkhauPasswordField1.getPassword()).equals("")){
            JOptionPane.showMessageDialog(this, "vui lòng nhập mật khẩu");
            return 0;
        }
        else if(!String.valueOf(matkhauPasswordField1.getPassword()).equals(String.valueOf(xacnhanPasswordField2.getPassword()))){
            JOptionPane.showMessageDialog(this, "mật khẩu không khớp");
            return 0;
        }
        else if(tenTextField4.getText().equals("")){
            JOptionPane.showMessageDialog(this, "vui lòng nhập tên");
            return 0;
        }
        return 1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        taikhoanTextField = new javax.swing.JTextField();
        tenTextField4 = new javax.swing.JTextField();
        dangkyButton1 = new javax.swing.JButton();
        matkhauPasswordField1 = new javax.swing.JPasswordField();
        xacnhanPasswordField2 = new javax.swing.JPasswordField();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Đăng ký");

        jLabel2.setText("Tài khoản");

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Xác nhận ");

        jLabel5.setText("Tên");

        taikhoanTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taikhoanTextFieldActionPerformed(evt);
            }
        });

        tenTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenTextField4ActionPerformed(evt);
            }
        });

        dangkyButton1.setText("Đăng ký");
        dangkyButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangkyButton1ActionPerformed(evt);
            }
        });

        backButton.setText("Quay lại");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dangkyButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(taikhoanTextField)
                                    .addComponent(tenTextField4)
                                    .addComponent(matkhauPasswordField1)
                                    .addComponent(xacnhanPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(taikhoanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(matkhauPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(xacnhanPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tenTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(dangkyButton1)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void taikhoanTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taikhoanTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taikhoanTextFieldActionPerformed

    private void tenTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenTextField4ActionPerformed

    private void dangkyButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangkyButton1ActionPerformed
        int check = check();
        if(check==0) return;
        
        user = new User(taikhoanTextField.getText(),String.valueOf(matkhauPasswordField1.getPassword()), tenTextField4.getText(), 0, 0, 0, 0, "active");
        clientCtrl.openConnection();
        clientCtrl.sendRequest(new UserRequest("register",user));
        JOptionPane.showMessageDialog(this, "Đăng ký thành công");
        new LoginView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dangkyButton1ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        new LoginView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton dangkyButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField matkhauPasswordField1;
    private javax.swing.JTextField taikhoanTextField;
    private javax.swing.JTextField tenTextField4;
    private javax.swing.JPasswordField xacnhanPasswordField2;
    // End of variables declaration//GEN-END:variables
}
