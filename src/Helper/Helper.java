package Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static int ScreenCoord(String eksen, Dimension size){
        int point;
        switch (eksen){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.width) / 2;
                break;
            default:
                point = 0;
        }
        return point;
    }

    public static boolean confirm(String str) {
        optionPaneTR();

        String msg;

        switch (str) {
            case "sure":
                msg = "Bu işlemi gerçekleştirmek istediğinizden emin misiniz?";
                break;
            default:
                msg = str;

        }
        return JOptionPane.showConfirmDialog(null, msg, "Kontrol", JOptionPane.YES_NO_OPTION) == 0;


    }

    public static void optionPaneTR() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.noButtonText", "Hayır");
        UIManager.put("OptionPane.yesButtonText", "Evet");
    }

    public static void setLayout() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

    public static boolean isFieldEmpty(JTextField textField) {
        return textField.getText().trim().isEmpty();

    }

    public static void showMessage(String str) {
        optionPaneLangTr();
        String message;
        String title;

        switch (str) {
            case "fill":
                message = "Lütfen tüm alanları doldurunuz!";
                title = "Hata!";
                break;
            case "done":
                message = "İşlem Başarılı";
                title = "Başarılı İşlem";
                break;
            case "error":
                message = "Ekleme Başarısız";
                title = "Hata";
                break;
            case "duplicate":
                message = "Aynı kullanıcı adı daha önce kullanılmış.";
                title = "Uyarı";
                break;
            default:
                message = str;
                title = "Mesaj";
        }
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }


    public static void optionPaneLangTr() {
        UIManager.put("OptionPane.okButtonText", "Tamam");

    }
}
