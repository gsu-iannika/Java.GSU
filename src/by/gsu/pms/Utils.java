package by.gsu.pms;

import by.gsu.pms.exception.DrugstoreDeserialized;
import by.gsu.pms.exception.DrugstoreSerialized;

import java.io.*;

public class Utils {
    public static void saveDrugstores(Drugstore[] drugstores) throws DrugstoreSerialized {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/drugstores.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(Drugstore drugstore : drugstores) {
                out.writeObject(drugstore);
            }
            out.close();
            fileOut.close();
        } catch (IOException e) {
            throw new DrugstoreSerialized("Error with drugstore serialization", e);
        }
    }

    public static Drugstore[] getDrugstores(int size) throws ClassNotFoundException, DrugstoreDeserialized {
        Drugstore[] drugstores = new Drugstore[size];
        try {
            FileInputStream fileIn = new FileInputStream("src/drugstores.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for(int i = 0; i < size; i++) {
                drugstores[i] = (Drugstore) in.readObject();
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            throw new DrugstoreDeserialized("Error with drugstore deserialization", i);
        } catch (ClassNotFoundException e) {
            System.out.println("Drugstore class not found");
            throw e;
        }

        return drugstores;
    }

}
