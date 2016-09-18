package catan.java.src.client.poller;
import org.json.JSONObject;

import java.util.TimerTask;
/**
 * 
 * @author Danny
 *This class performs the actions of requesting a new model from the server and sending updated information to the controller.
 */
public class PollTask extends TimerTask{
	
	/**
	 * This is the variable which references the Poller object which originally created this PollTask object.
	 */
	private Poller poller;
	
	/**
	 * PollTask constructor.  This simply creates a relationship between the PollTask and the Poller.  Without a setPoller method, this parameterized constructor is the only time this
	 * relationship can be established.
	 * @pre The Poller constructing this object must be correctly defined, in that it has valid controller and proxy variable assignments.
	 * @post This object will have access to all protected methods in the Poller class, with which it can construct proxy requests and send JSON information to the controller
	 * @param poll The poller object whose constructor calls this object's constructor.
	 */
	protected PollTask(Poller poll)//will set poller to game's only poller
	{
	}
	
	/**
	 * Method which is required by the TimerTask abstract class.  This is what gets executed at fixed intervals defined by the Timer t in the Poller.
	 * @pre None
	 * @post The PollTask will receive one of two results from the server proxy/server: 1) No changes have been made, or 2) a JSONObject congruent with the pattern defined by the server.
	 * If it receives the later, the PollTask will send the JSONObject to the controller via the Poller
	 */
	public void run()
	{
		
	}
	
	/**
	 * The PollTask requests (via the Poller) the current model version from the controller.  This number is used to create the update object which the server proxy uses to talk to 
	 * the server.
	 * @pre The PollTask must have a reference to a functional Poller, and the Poller must have a reference to a functional controller (implicit in the construction of the PollTask and
	 *  Poller objects).
	 * @post the PollTask will have the most current version number to pass to the server proxy (via the updateObject).
	 * @return the most current model version number, as defined by the controller.
	 */
	private int getModelVersion()//calls same method on poller, which then talks to controller
	{
		//TODO: Need to check if the model version will just be an int
	}
	
	/**
	 * The PollTask requests (via the Poller) the ID of the player whose turn it currently is.  This number is used to create the update object which the server proxy uses to talk to 
	 * the server.
	 * @pre The PollTask must have a reference to a functional Poller, and the Poller must have a reference to a functional controller (implicit in the construction of the PollTask and
	 *  Poller objects).
	 * @post the PollTask will have the ID of the player whose turn it currently is, to pass to the server proxy (via the updateObject).
	 * @return the ID of the player whose turn it currently is.
	 */
	private catan.java.src.shared.definitions.PlayerIndex getCurrentPlayer()//gets player index to be included in update object; for validation
	{
	}

}
