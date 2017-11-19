import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class ChatImpl extends app.chatPOA{
		
	private ArrayList<String> talk_registry;
	private ORB orba;
	private static app.talk current_talk;
	
	public ChatImpl(ORB orb) throws InvalidName {
		this.orba = orb;
		this.talk_registry = new ArrayList<String>();
	}
	
	@Override
	public void broadcast(String message) {
		
		int i = 0;
		NamingContext nameRoot;
		String current_talk_id;
		
		try {
			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orba.resolve_initial_references("NameService"));
			
			do{
			
			current_talk_id = this.talk_registry.get(i);
				
			// Construction du nom a rechercher
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	        nameToFind[0] = new org.omg.CosNaming.NameComponent(current_talk_id,"");

	        // Recherche aupres du naming service
	        org.omg.CORBA.Object distantTalk = nameRoot.resolve(nameToFind);
	        
	        current_talk = app.talkHelper.narrow(distantTalk);
	        
	        current_talk.printMessage(message);
	        
	        i++;
	        
			}while(i < talk_registry.size());
	        
		} catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void register(String idObj) {
		this.talk_registry.add(idObj);
	}
	
}

