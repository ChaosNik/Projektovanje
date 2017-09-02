package data.dao.mysql;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.KonkursDAO;
import data.dto.KonkursDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLKonkursDAO implements KonkursDAO {

    static int brojac = 0;

    @Override
    public KonkursDTO konkurs(String skolskaGodina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String readPDF(String skolskaGodina) {
        String lokacija = "";
        try {
            Connection conn = ConnectionPool.getInstance().checkOut();

            String sql = "SELECT SkolskaGodina, TekstKonkursa , Format FROM konkurs WHERE SkolskaGodina=\"" + skolskaGodina + "\"";
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(sql);
            ResultSet resultSet = null;
            resultSet = stmt.executeQuery();

            try {
                while (resultSet.next()) {

                    Path currentRelativePath = Paths.get("");
                    String s = currentRelativePath.toAbsolutePath().toString();

                    lokacija = s + "rezultat" + (brojac++) + "." + resultSet.getString(3);

                    File image = new File(lokacija);
                    FileOutputStream fos = new FileOutputStream(image);

                    byte[] buffer = new byte[1];
                    InputStream is = resultSet.getBinaryStream(2);
                    if (is == null) {
                        return "";
                    }
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    fos.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySQLKonkursDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lokacija;
    }

    @Override
    public List<KonkursDTO> konkursi() {
        return null;

    }

    @Override
    public boolean dodajKonkurs(KonkursDTO konkurs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean azurirajKonkurs(KonkursDTO konkurs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean obrisiKonkurs(String skolskaGodina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
