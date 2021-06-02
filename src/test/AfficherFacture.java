package test;

import models.FactureFournisseurLibre;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AfficherFacture {
    public static void afficherfacture(FactureFournisseurLibre B) {
        File file = new File(System.getProperty("user.dir") + "/" + "src/view/components/facture.html");
        try {
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<head>\n" +
                    "  <meta charset=\"UTF-8\"/>\n" +
                    "  <title>Facture pour " + B.getFournisseur().toString() + "</title>\n" +
                    "  <link href=\"https://fonts.googleapis.com/css?family=Nunito:300|Raleway:200,300\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
                    "<link href=\"style.css\" rel='stylesheet' type='text/css'>" +
                    "</head>\n");
            bw.write("<body>\n" +
                    "  <header>\n" +
                    "    <h1>FACTURE\n" +
                    "      <h2>PolyEntreprise</h2>\n" +
                    "    </h1>\n" +
                    "  </header>\n" +
                    "  <section class=\"flex\">\n" +
                    "    <dl>\n" +
                    "      <dt>Facture #</dt>\n" +
                    "      <dd>" + B.getCode() + "</dd>\n" +
                    "      <dt>Date de facturation</dt>\n" +
                    "      <dd>" + B.getDatedebon().toString() + "</dd>\n" +
                    "    </dl>\n" +
                    "  </section>");
            bw.write("<section class=\"flex\">\n" +
                    "    <dl class=\"bloc\">\n" +
                    "        <dt>Facturé à:</dt>\n" +
                    "        <dd>\n" +
                    B.getFournisseur().getRaison() + "            <br>\n" +
                    B.getFournisseur().getAddress().getPays() + "            ,<br>\n" +
                    B.getFournisseur().getAddress().getLibelle() +
                    "            ," + B.getFournisseur().getAddress().getVille() + "" +
                    ", " + B.getFournisseur().getAddress().getCodePostal() + "\n" +
                    "            <dl>\n" +
                    "                <dt>Matricule</dt>\n" +
                    "                <dd>" +
                    B.getFournisseur().getMatricule() +
                    "</dd>\n" +
                    "                <dt>Téléphone</dt>\n" +
                    "                <dd>" +
                    B.getFournisseur().getNumPortable() +
                    "</dd>\n" +
                    "                <dt>Courriel</dt>\n" +
                    "                <dd>" +
                    B.getFournisseur().getEmail() +
                    "</dd>\n" +
                    "            </dl>\n" +
                    "        </dd>\n" +
                    "    </dl>\n" +
                    "    <dl class=\"bloc\">\n" +
                    "        <dt>Methode de Payement</dt>\n" +
                    "        <dd>" + B.getModepayment() +
                    "</dd>\n" +
                    "        <dt>Information</dt>\n" +
                    "        <dd>" + B.getInformation() +
                    "</dd>\n" +
                    "    </dl>\n" +
                    "</section>");
            bw.write("<table>\n" +
                    "    <thead>\n" +
                    "      <tr> \n" +
                    "        <th>Réference</th>\n" +
                    "        <th>Designation</th>\n" +
                    "        <th>Quantité</th>\n" +
                    "        <th>TVA</th>\n" +
                    "         <th>Prix Unitaire</th>" +
                    "        <th>Montant</th>\n" +
                    "      </tr>\n" +
                    "    </thead>");

            B.getListeproduit().forEach(((produit, value) -> {
                try {
                    bw.write("<tbody>\n" +
                            "      <tr>\n" +
                            "        <td>" + produit.getReference() + "</td>\n" +
                            "        <td>" + produit.getDesignation() + "</td>\n" +
                            "        <td>" + value + "</td>\n" +
                            "        <td>" + produit.getTva() + "%</td>\n" +
                            "        <td>" + produit.getPrixunitaire() + "</td>\n" +
                            "        <td>" + produit.getPrixunitaire() * value + "</td>\n" +
                            "      </tr>\n" +
                            "    </tbody>");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));


            bw.write("    <tfoot>\n" +
                    "      <tr> \n" +
                    "        <td colspan=\"4\"></td>\n" +
                    "        <td>TTC:</td>\n" +
                    "        <td>" + B.getPrixtotal() + "</td>\n" +
                    "      </tr>\n" +
                    "    </tfoot>");

            bw.write("    <tfoot>\n" +
                    "      <tr> \n" +
                    "        <td colspan=\"4\"></td>\n" +
                    "        <td>Total:</td>\n" +
                    "        <td>" + B.getPrixhorstva() + "</td>\n" +
                    "      </tr>\n" +
                    "    </tfoot>");
            bw.write("    <tfoot>\n" +
                    "      <tr> \n" +
                    "        <td colspan=\"4\"></td>\n" +
                    "        <td>TVA:</td>\n" +
                    "        <td>" + B.getTvatotal() + "</td>\n" +
                    "      </tr>\n" +
                    "    </tfoot>");

            bw.write("</table>");
            bw.close();
            fw.close();
            Desktop desktop = Desktop.getDesktop();

            try {
                desktop.open(file);              //opens the specified file
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
