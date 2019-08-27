package catpic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 * @author Michael
 */
public class Display extends javax.swing.JFrame {

    public String getCat() throws Exception {
        URL url = new URL("http://aws.random.cat/meow");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.getResponseCode();
        InputStream input = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(input));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
        }
        rd.close();
        line = response.toString();
        Pattern pattern = Pattern.compile("(?=http)(.*?)\"");
        Matcher matcher = pattern.matcher(line);
        
        if (!matcher.find()) {
            return "Nothing";
        }
        return matcher.group(1);
    }
    
    public Display() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        displayCat = new javax.swing.JLabel();
        NewPic = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        displayCat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayCat.setIcon(new javax.swing.ImageIcon("C:\\Users\\MyPC\\Desktop\\Others\\Java\\CatPic\\build\\classes\\catpic\\cat.jpg")); // NOI18N
        jPanel1.add(displayCat);
        displayCat.setBounds(0, 0, 400, 260);

        NewPic.setText("New Cat!");
        NewPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(NewPic)
                .addGap(161, 161, 161))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NewPic)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPicActionPerformed
        try {
            String url = getCat().replace("\\/", "/");
            URL a = new URL(url);
            BufferedImage image = ImageIO.read(a);
            ImageIcon icon = new ImageIcon(image);
            image.getScaledInstance(768,1024,java.awt.Image.SCALE_SMOOTH);
            this.displayCat.setIcon(icon);
        } catch(Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_NewPicActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NewPic;
    private javax.swing.JLabel displayCat;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
