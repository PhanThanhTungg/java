
package Client.view;

import Client.controller.ClientCtrl;
import javax.swing.JOptionPane;
import model.User;
import model.UserRequest;

public class LoginView extends javax.swing.JFrame {
    User user;
    ClientCtrl clientCtrl;
    UserRequest userRequest;
    public LoginView() {
        initComponents();
        clientCtrl = new ClientCtrl();
    }
    
    private int check(){
        if(taikhoanTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(this, "vui lòng nhập tài khoản");
            return 0;
        }
        else if(String.valueOf(matkhauPasswordField1.getPassword()).equals("")){
            JOptionPane.showMessageDialog(this, "vui lòng nhập mật khẩu");
            return 0;
        }
        return 1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        taikhoanTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dangNhapButton1 = new javax.swing.JButton();
        matkhauPasswordField1 = new javax.swing.JPasswordField();
        dangkyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Đăng nhập");

        jLabel2.setText("Tài khoản");

        taikhoanTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taikhoanTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Mật khẩu");

        dangNhapButton1.setText("Đăng nhập");
        dangNhapButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangNhapButton1ActionPerformed(evt);
            }
        });

        dangkyButton.setText("Đăng ký");
        dangkyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangkyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(taikhoanTextField1)
                            .addComponent(matkhauPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dangNhapButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dangkyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(taikhoanTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(matkhauPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(dangNhapButton1)
                .addGap(18, 18, 18)
                .addComponent(dangkyButton)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void taikhoanTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taikhoanTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taikhoanTextField1ActionPerformed

    private void dangNhapButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangNhapButton1ActionPerformed
        int check = check();
        if(check==0) return;
        clientCtrl.openConnection();
        clientCtrl.sendRequest(new UserRequest("login",new User(taikhoanTextField1.getText(),String.valueOf(matkhauPasswordField1.getPassword()))));
        String flag = clientCtrl.recieveFlag();
        System.out.println(flag);
        if(flag.equals("login successfully")){
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
            new HomeView().setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai");
        }
    }//GEN-LAST:event_dangNhapButton1ActionPerformed

    private void dangkyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangkyButtonActionPerformed
        new RegisterView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dangkyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dangNhapButton1;
    private javax.swing.JButton dangkyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField matkhauPasswordField1;
    private javax.swing.JTextField taikhoanTextField1;
    // End of variables declaration//GEN-END:variables
}
