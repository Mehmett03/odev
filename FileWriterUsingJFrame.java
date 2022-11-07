import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUsingJFrame implements ActionListener {
     JFrame window=new JFrame("form gir");
     JTextField userNameTextField= new JTextField();
     JTextField surNameTextField=new JTextField();
     JLabel userNameLabel=new JLabel("adınız :");
     JLabel surNameLabel=new JLabel("Soyadınız:");
     JButton signupbutton=new JButton("Kaydet");
     JLabel blank=new JLabel();
     FileWriter fileWriter;

     FileWriterUsingJFrame()
     {
         GridLayout gl=new GridLayout();
         gl.setColumns(2);
         gl.setRows(3);

         window.setLayout(gl);
         signupbutton.addActionListener(this);

         window.add((userNameLabel));
         window.add(userNameTextField);
         window.add(surNameLabel);
         window.add(surNameTextField);
         window.add(blank);
         window.add(signupbutton);

         window.setSize(300,200);
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.setVisible(true);
     }
    @Override
    public void actionPerformed(ActionEvent  ae)
    {
        try {
            fileWriter= new FileWriter("txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (ae.getActionCommand()==signupbutton.getActionCommand())
         {
             try
              {

                fileWriter.write(userNameLabel.getText()+" : "+userNameTextField.getText()+"\n");
                fileWriter.write(surNameLabel.getText()+" : "+surNameTextField.getText());
                fileWriter.close();
                JOptionPane.showMessageDialog(null,"Kaydedildi");
              }
             catch (Exception e)
              {
             JOptionPane.showMessageDialog(null, e + "");
              }
        }
    }
}
