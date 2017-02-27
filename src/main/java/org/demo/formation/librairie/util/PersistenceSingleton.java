package org.demo.formation.librairie.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.demo.formation.librairie.entity.common.IEntity;

public  class PersistenceSingleton<TypeID> {

	private static boolean isStoreInit = false;
	public static String FILE_DATA_STORE = System.getProperty("java.io.tmpdir") + "/database.map";
	private static Logger LOGGER = Logger.getLogger(PersistenceSingleton.class.getName());
	/** Récupère l'instance unique de la class PersistenceSingleton.<p>
	 * 
	 */
	public static synchronized  PersistenceSingleton getInstance() {
		if (INSTANCE == null)	{ 
			INSTANCE = new PersistenceSingleton();	
		}
		return INSTANCE;
	}

	/** Constructeur redéfini comme étant privé pour interdire
	 * son appel et forcer à passer par la méthode <link
	 */
	private PersistenceSingleton() {
		try
		{
			//Juste pour initialiser quelques enregistrements en mémoires
			FileOutputStream fos =	new FileOutputStream(FILE_DATA_STORE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.close();
			fos.close();
			LOGGER.log(Level.INFO,"Serialized HashMap data is saved in "+ FILE_DATA_STORE);
		}catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	/** L'instance statique */
	private static PersistenceSingleton INSTANCE = null;

	public <TypeID> void setStoreData(HashMap<String, IEntity<TypeID>> mapEntity){
		try	{
			FileOutputStream fos =	new FileOutputStream(FILE_DATA_STORE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(mapEntity);
			oos.close();
			fos.close();
			isStoreInit = true;
		}catch(IOException ioe)		{
			ioe.printStackTrace();
			LOGGER.log(Level.SEVERE,ioe.getMessage());
		}
	}

	public <TypeID> HashMap<String, IEntity<TypeID>>  getStoreData(){ 
		HashMap<String, IEntity<TypeID>> mapToReturn = new HashMap<String, IEntity<TypeID>>();
		try
		{
			FileInputStream fis = new FileInputStream(FILE_DATA_STORE);
			ObjectInputStream ois = new ObjectInputStream(fis);
			mapToReturn = (HashMap<String, IEntity<TypeID>>) ois.readObject();
			if (mapToReturn == null){
				 mapToReturn = new HashMap<String,IEntity<TypeID>>();
			}
			ois.close();
			fis.close();
		}catch(IOException ioe)
		{
			//ioe.printStackTrace();
			LOGGER.log(Level.SEVERE,ioe.getMessage());
		}catch(ClassNotFoundException c)
		{
			System.err.println("Class not found");
			LOGGER.log(Level.SEVERE,c.getMessage());
		}
		return mapToReturn;
	}

	public boolean isStoreInit() {
		return isStoreInit;
	}
}
