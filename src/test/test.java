package test;

import controller.*;
import models.Address;
import models.FactureFournisseurLibre;
import models.Produit;

import java.sql.Date;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        /*EntrepriseService entrepriseService=new EntrepriseService();
        ClientService clientService=new ClientService();
        ProduitService ps=new ProduitService();
        FournisseurService fournisseurService=new FournisseurService();
        BonFournisseurService bfs=new BonFournisseurService();
        HashMap<Produit,Integer> listproduit=new HashMap<>();
        ArrayList<BankAccount> bankAccounts=new ArrayList<>();
        Address address=new Address("edit","editdfsdfdsf","editfsfdf","editdsfsdfsf"
                ,"editsdfsdf","editsdfsdf");
        bankAccounts.add(new BankAccount("dsfsdfssdf2","dsfsdfsf","dsfdsfsdf"));
        bankAccounts.add(new BankAccount("dsfsdfssdf4","dsfsdfsf2","dsfdsfsdf2"));
        Entreprise entreprise=new Entreprise("223/243/243","raisonediter",
                "morale",bankAccounts,address,"5555556","5555555editer",
                "55555555editer",Boolean.TRUE,"Big Fucking Company editer");
        entreprise.setEmail("logong@logong.log");
        Client client=new Client("holyshit","Attia Raed","morale",bankAccounts,address,"fffff",
                "ffff","45454",true,"4165151561");
        Client fournisseur=new Client("hhhhhediteee","fournisseur","physique",bankAccounts,
                address,"512121","546545","65456",true,"codefour");
        //clientService.add(client);
        //fournisseurService.add(fournisseur);
        //fournisseurService.delete("codefour");
        //AddressService addressService=new AddressService("fournisseur");
        //addressService.edit(address,"codefour");
        //System.out.println(addressService.getaddress("codefour"));
        //System.out.println(fournisseurService.getByName("raed"));
        //entrepriseService.edit(entreprise);
        listproduit.put(ps.get("57857"),10);

        bfs.add(bonFournisseur);
        System.out.println(ps.getAll());
        HashMap<Produit, Integer> hashMap=new HashMap<Produit, Integer>();
        hashMap.put(ps.get("57857"),50);
        System.out.println(hashMap.get(ps.get("57857")));
        System.out.println(ps.get("57857").equals(ps.get("57857")));
        System.out.println(ps.get("57857").hashCode());*/
        // System.out.println("aa".equals("aaa"));
        //BonFournisseurService bfs=new BonFournisseurService();

        //fficherFacture.afficherfacture(bfs.get("Bon16"));
        EntrepriseService entrepriseService = new EntrepriseService();
        ClientService clientService = new ClientService();
        ProduitService ps = new ProduitService();
        FournisseurService fournisseurService = new FournisseurService();
        BonFournisseurService bfs = new BonFournisseurService();
        HashMap<Produit, Integer> listproduit = new HashMap<>();
        listproduit.put(ps.get("fffff"), 3);
        System.out.println(listproduit);
        FactureFournisseurLibre flibre = new FactureFournisseurLibre(1, "facture25",
                fournisseurService.get("codefour"), new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()), new Address(), "hahahah", listproduit,
                "Cheque");
        FactureFournisseurLibreService ffls = new FactureFournisseurLibreService();
        ffls.add(flibre, flibre.getModepayment());


    }
}
