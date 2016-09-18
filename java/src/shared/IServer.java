package shared;

import shared.outputObjects.*;
import client.ClientException;
import shared.inputObjects.*;

/**
 * The server interface
 * @author Dell
 *
 */
public interface IServer {

	/**
	 * Logins the user from the input provided. Verifies that the user exists
	 * @param input An object containing the LoginUser input parameters
	 * @return An object containing the LoginUser output parameters
	 * @throws ClientException 
	 * @pre 1. input is not null<br/>
	 * 		2. username is not null<br/>
	 * 		3. password is not null
	 * @post If valid user credentials are passed in:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The HTTP Response will set a cookie with the values of the player's username, password and ID<br/>
	 * 		 If invalid, the server returns an HTTP 400 error response
	 */
	public LoginUserOutput LoginUser(LoginUserInput input) throws ClientException;
	
	/**
	 * Creates a new user account and logs the user in to the server
	 * @param input An object containing the RegisterUser input parameters
	 * @return An object containing the RegisterUser output parameters
	 * @throws ClientException
	 * @pre 1. input is not null<br/>
	 * 		2. username is not null<br/>
	 * 		3. password is not null<br/>
	 * 		4. the specified username is not already in use
	 * @post If there is no existing user with the given username:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. A new user account is created with the given credentials<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;3. The HTTP Response will set a cookie with the values of the player's username, password and ID<br/>
	 * 		 If invalid, the server returns an HTTP 400 error response
	 */
	public RegisterUserOutput RegisterUser(RegisterUserInput input) throws ClientException;
	
	/**
	 * Gets a list of all the current games running on the server
	 * @return An object containing the CurrentGames output parameters
	 * @throws ClientException
	 * @pre none
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The body of the response will contain a JSON object that contains the information on each current game<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public CurrentGamesOutput GetCurrentListOfGames() throws ClientException;
	
	/**
	 * Creates a new game on the server
	 * @param input An object containing the CreateGame input parameters
	 * @return An object containing the CreateGame output parameters
	 * @throws ClientException
	 * @pre 1. input is not null<br/>
	 * 		2. name is not null<br/>
	 * 		3. randomTiles, randomNumbers, and randomPorts contain valid boolean values
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. A new game will have been created<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;3. The body of the response will contain a JSON object describing the created game<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public CreateGameOutput CreateGame(CreateGameInput input) throws ClientException;
	
	/**
	 * Adds the player to the specified game
	 * @param input An object containing the JoinGame input parameters
	 * @return An object containing the JoinGame output parameters
	 * @throws ClientException
	 * @pre 1. input is not null<br/>
	 * 		2. The user has previously logged in to the server<br/>
	 * 		3. The player can join the game if the user is already in the game or there is an opening for the player to join<br/>
	 * 		4. The game ID is valid<br/>
	 * 		5. The color is valid (red, green, blue, yellow, puce, brown, white, purple, orange)
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The player is added to the game with the specified color<br/>
	 * 			&nbsp;&nbsp;&nbsp;3. The catan game cookie is updated<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public JoinGameOutput JoinGame(JoinGameInput input) throws ClientException;
	
	/**
	 * Save the current state of the game to a file and include a bug report. This file can be used later to restore the game to the saved state
	 * @param input An object containing the SaveGame input parameters
	 * @return An object containing the SaveGame output parameters
	 * @throws ClientException
	 * @pre 1. input is not null<br/>
	 * 		2. The game ID is valid<br/>
	 * 		3. The file name is valid (not null or empty)
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The current state of the game is saved to the server's file system<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public SaveGameOutput SaveGame(SaveGameInput input) throws ClientException;
	
	/**
	 * Previously saved states of the game can be loaded from the server's file system
	 * @param input An object containing the LoadGame input parameters
	 * @return An object containing the LoadGame output parameters
	 * @throws ClientException
	 * @pre A previously saved game file with the specified name exists in the directory
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The saved game will now have been loaded with its state restored<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public LoadGameOutput LoadGame(LoadGameInput input) throws ClientException;
	
	/**
	 * Returns the current state of the game in a JSON object. If a version number is included, the state will only be returned if there is a newer version. If it needs no update, it will be indicated in the output parameters
	 * @param input An object containing the UpdateCurrentGameState input parameters
	 * @return An object containing the UpdateCurrentGameState output parameters
	 * @throws ClientException
	 * @pre 1. The caller requesting the updated game state has previously logged in to the server and joined a game<br/>
	 * 		2. If a version number is included, its value is a valid integer
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The response will contain JSON object data<br/>
	 * 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a. The full model in JSON will be returned if a version number was not included, or the version numbers did not match<br/>
	 * 				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b. "true" is returned if a version number was included and matched the version of the model on the server<br/>
	 *		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public UpdateCurrentGameStateOutput UpdateCurrentGameState(UpdateCurrentGameStateInput input) throws ClientException;
	
	/**
	 * Resets the game to its original state and clears out the command history for the game
	 * If a server-created game is reset, the game returns to its state just after the initial placement round, otherwise (if its a player-created game) the game is reset to before the initial placement round.
	 * The client model JSON object will be returned in the output parameters
	 * @param input An object containing the ResetGame input parameters
	 * @return An object containing the ResetGame output parameters
	 * @throws ClientException
	 * @pre The caller has previously logged in to the server and joined a game
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The game's command history has been cleared out<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The game's players have not been cleared out<br/>
	 * 			&nbsp;&nbsp;&nbsp;3. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;4. The game's updated client model JSON object will be in the response<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public ResetGameOutput ResetGame(ResetGameInput input) throws ClientException;
	
	/**
	 * Gets a list of the commands that have been executed in the current game, this allows the user to later re-execute these commands for testing
	 * @return An object containing the GetCommandsForGame output parameters
	 * @throws ClientException
	 * @pre The caller has previously logged in to the server and joined a game
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The response will contain a JSON object that has the list of commands that were executed<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public GetCommandsForGameOutput GetCommandsForGame() throws ClientException;
	
	/**
	 * Executes the specified list of commands for the current game. A new JSON object for the game model will be returned containing the changes
	 * @param input An object containing the SetCommandsForGame input parameters
	 * @return An object containing the SetCommandsForGame output parameters
	 * @throws ClientException
	 * @pre The caller has previously logged in to the server and joined a game
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The given list of commands will have been executed and applied to the current game<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;3. The response will contain the updated model JSON object<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public SetCommandsForGameOutput SetCommandsForGame(SetCommandsForGameInput input) throws ClientException;
	
	/**
	 * Gets a list of all supported AI player types (only LARGEST_ARMY is supported)
	 * @return An object containing the AITypes output parameters
	 * @throws ClientException
	 * @pre none
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The response contains the list of AI types in a JSON object<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public AITypesOutput GetAITypes() throws ClientException;
	
	/**
	 * Adds an AI player to the current game
	 * @param input An object containing the AddAIPlayer input parameters
	 * @return An object containing the AddAIPlayer output parameters
	 * @throws ClientException
	 * @pre 1. The caller has previously logged in to the server and joined a game<br/>
	 * 		2. There is space in the game for another player<br/>
	 * 		3. The given AIType is valid
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. An AI player will have been added to the current game<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public AddAIPlayerOutput AddAIPlayer(AddAIPlayerInput input) throws ClientException;
	
	/**
	 * Sets the server's logging level
	 * @param input An object containing the ServerLogLevel input parameters
	 * @return An object containing the ServerLogLevel output parameters
	 * @throws ClientException
	 * @pre The caller specified a valid logging level. Valid values include: SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST
	 * @post If successful:<br/>
	 * 			&nbsp;&nbsp;&nbsp;1. The server will return an HTTP 200 success response<br/>
	 * 			&nbsp;&nbsp;&nbsp;2. The server will now be using the specified logging level<br/>
	 * 		 If unsuccessful, the server returns an HTTP 400 error response
	 */
	public ServerLogLevelOutput SetServerLogLevel(ServerLogLevelInput input) throws ClientException;
	
	/**
	 * Sends a specified message to the chat
	 * @param input An object containing the SendChat input parameters
	 * @return An object containing the SendChat output parameters
	 * @throws ClientException
	 * @pre The caller has already logged in to the server and joined a game
	 * @post The chat contains the specified message at the end
	 */
	public SendChatOutput SendChat(SendChatInput input) throws ClientException;
	
	/**
	 * Decides if the player accepts the trade
	 * @param input An object containing the AcceptTrade input parameters
	 * @return An object containing the AcceptTrade output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined a game<br/>
	 * 		2. You will have been offered a domestic trade<br/>
	 * 		3. To accept the offered trade, you have the required resources
	 * @post 1. If you accepted the trade, you and the player who offered swap the specified resources<br/>
	 * 		 2. If you declined the trade, no resources are exchanged<br/>
	 * 		 3. The trade offer is removed
	 */
	public AcceptTradeOutput AcceptTrade(AcceptTradeInput input) throws ClientException;
	
	/**
	 * The specified cards will be discarded from the player
	 * @param input An object containing the DiscardCards input parameters
	 * @return An object containing the DiscardCards output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined a game<br/>
	 * 		2. The status of the client model is "Discarding"<br/>
	 * 		3. You have over 7 cards<br/>
	 * 		4. You have the specified cards to discard in your hand
	 * @post 1. You gave up the specified resources<br/>
	 * 		 2. If you are the last one to discard, the client model status changes to "Robbing"
	 */
	public DiscardCardsOutput DiscardCards(DiscardCardsInput input) throws ClientException;
	
	/**
	 * Rolls a pair of "dice" to return a random number between 2 and 12
	 * @param input An object containing the RollDice input parameters
	 * @return An object containing the RollDice output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Rolling"
	 * @post The client model's status is now in "Discarding", "Robbing" or "Playing"
	 */
	public RollDiceOutput RollDice(RollDiceInput input) throws ClientException;
	
	/**
	 * Builds a road on the specified location
	 * @param input An object containing the BuildRoad input parameters
	 * @return An object containing the BuildRoad output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. The road location is open<br/>
	 * 		5. The road location is connected to another road owned by the player<br/>
	 * 		6. The road location is not on water<br/>
	 * 		7. You have the required resources (1 wood, 1 brick, 1 road) if the piece is not free (initial placement rounds)<br/>
	 * 		8. SETUP ROUND: Must be place by settlement owned by the player with no adjacent road.
	 * @post 1. You lost the resources required to build a road (1 wood, 1 brick, 1 road)<br/>
	 * 		 2. The road is on the map at the specified location<br/>
	 * 		 3. If applicable, "longest road" is awarded to the player with the longest road
	 */
	public BuildRoadOutput BuildRoad(BuildRoadInput input) throws ClientException;
	
	/**
	 * Builds a settlement on the specified location
	 * @param input An object containing the BuildSettlement input parameters
	 * @return An object containing the BuildSettlement output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. The settlement location is open<br/>
	 * 		5. The settlement location is not on water<br/>
	 * 		6. The settlement location is connected to one of your roads except during setup<br/>
	 * 		7. You have the required resources (1 wood, 1 brick, 1 wheat, 1 sheep, 1 settlement)<br/>
	 * 		8. The settlement cannot be place adjacent to another settlement
	 * @post 1. You lost the resources required to build a settlement (1 wood, 1 brick, 1 wheat, 1 sheep, 1 settlement)<br/>
	 * 		 2. The settlement is on the map at the specified location
	 */
	public BuildSettlementOutput BuildSettlement(BuildSettlementInput input) throws ClientException;
	
	/**
	 * Builds a city on the specified location
	 * @param input An object containing the BuildCity input parameters
	 * @return An object containing the BuildCity output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. The city location is where you currently have a settlement<br/>
	 * 		5. You have the required resources (2 wheat, 3 ore, 1 city)
	 * @post 1. You lost the resources required to build a city (2 wheat, 3 ore, 1 city)<br/>
	 * 		 2. The city is on the map at the specified location<br/>
	 * 		 3. You got a settlement back
	 */
	public BuildCityOutput BuildCity(BuildCityInput input) throws ClientException;
	
	/**
	 * A player offers a trade with another player
	 * @param input An object containing the OfferTrade input parameters
	 * @return An object containing the OfferTrade output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the resources you are offering
	 * @post The trade is offered to the other player
	 */
	public OfferTradeOutput OfferTrade(OfferTradeInput input) throws ClientException;
	
	/**
	 * A player offers a trade to one of the ports
	 * @param input An object containing the MaritimeTrade input parameters
	 * @return An object containing the MaritimeTrade output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the resources you are giving<br/>
	 * 		5. For ratios less than 4, you have the correct port for the trade
	 * @post The trade has been executed (the offered resources are in the bank and the requested resource has been received)
	 */
	public MaritimeTradeOutput MaritimeTrade(MaritimeTradeInput input) throws ClientException;
	
	/**
	 * The robber is moved to a new location and resources are stolen from a nearby player
	 * @param input An object containing the RobPlayer input parameters
	 * @return An object containing the RobPlayer output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. The robber is not kept in the same location<br/>
	 * 		5. If a player is being robbed, the player being robbed has resource cards
	 * @post 1. The robber is in the new location<br/>
	 * 		 2. The player being robbed (if any) gave you one of his resource cards (randomly selected)
	 */
	public RobPlayerOutput RobPlayer(RobPlayerInput input) throws ClientException;
	
	/**
	 * Finishes a player's turn
	 * @param input An object containing the FinishTurn input parameters
	 * @return An object containing the FinishTurn output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"
	 * @post 1. The cards in your new dev card hand have been transferred to your old dev card hand<br/>
	 * 		 2. It is the next player's turn
	 */
	public FinishTurnOutput FinishTurn(FinishTurnInput input) throws ClientException;
	
	/**
	 * Gives a development card to the player
	 * @param input An object containing the BuyDevCard input parameters
	 * @return An object containing the BuyDevCard output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the required resources (1 ore, 1 wheat, 1 sheep)<br/>
	 * 		5. There are dev cards left in the deck
	 * @post You have a new card<br/>
	 * 			&nbsp;&nbsp;&nbsp;- If it is a monument card, it has been added to your old dev card hand<br/>
	 * 			&nbsp;&nbsp;&nbsp;- If it is a non-monument card, it has been added to your new dev card hand (unplayable this turn)
	 */
	public BuyDevCardOutput BuyDevCard(BuyDevCardInput input) throws ClientException;
	
	/**
	 * A player plays a soldier card
	 * @param input An object containing the PlaySoldierCard input parameters
	 * @return An object containing the PlaySoldierCard output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the specific card you want to play in your old dev card hand<br/>
	 * 		5. You have not yet played a non-monument dev card this turn<br/>
	 * 		6. The robber is not being kept in the same location<br/>
	 * 		7. If a player is being robbed, the player being robbed has resource cards
	 * @post 1. The robber is in the new location<br/>
	 * 		 2. The player being robbed (if any) gave you one of his resource cards (randomly selected)<br/>
	 * 		 3. If applicable, "largest army" has been awarded to the player who has played the most soldier cards<br/>
	 * 		 4. You are not allowed to play other development cards during this turn (except for monument cards)
	 */
	public PlaySoldierCardOutput PlaySoldierCard(PlaySoldierCardInput input) throws ClientException;
	
	/**
	 * A player plays a year of plenty card
	 * @param input An object containing the PlayYearOfPlentyCard input parameters
	 * @return An object containing the PlayYearOfPlentyCard output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the specific card you want to play in your old dev card hand<br/>
	 * 		5. You have not yet played a non-monument dev card this turn<br/>
	 * 		6. The two specified resources are in the bank
	 * @post You gained the two specified resources
	 */
	public PlayYearOfPlentyCardOutput PlayYearOfPlentyCard(PlayYearOfPlentyCardInput input) throws ClientException;
	
	/**
	 * A player plays a road building card
	 * @param input An object containing the PlayRoadBuildingCard input parameters
	 * @return An object containing the PlayRoadBuildingCard output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the specific card you want to play in your old dev card hand<br/>
	 * 		5. You have not yet played a non-monument dev card this turn<br/>
	 * 		6. The first road location is connected to one of your roads<br/>
	 * 		7. The second road location is connected to one of your roads or to the first road location<br/>
	 * 		8. Neither road location is on water<br/>
	 * 		9. You have at least two unused roads
	 * @post 1. You have two fewer unused roads<br/>
	 * 		 2. Two new roads appear on the map at the specified locations<br/>
	 * 		 3. If applicable, "longest road" has been awarded to the player with the longest road
	 */
	public PlayRoadBuildingCardOutput PlayRoadBuildingCard(PlayRoadBuildingCardInput input) throws ClientException;
	
	/**
	 * A player plays a monopoly card
	 * @param input An object containing the PlayMonopolyCard input parameters
	 * @return An object containing the PlayMonopolyCard output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the specific card you want to play in your old dev card hand<br/>
	 * 		5. You have not yet played a non-monument dev card this turn
	 * @post All of the other players have given you all of their resource cards of the specified type
	 */
	public PlayMonopolyCardOutput PlayMonopolyCard(PlayMonopolyCardInput input) throws ClientException;
	
	/**
	 * A player plays a monument card
	 * @param input An object containing the PlayMonumentCard input parameters
	 * @return An object containing the PlayMonumentCard output parameters
	 * @throws ClientException
	 * @pre 1. The caller has already logged in to the server and joined the game<br/>
	 * 		2. It is your turn<br/>
	 * 		3. The client model's status is "Playing"<br/>
	 * 		4. You have the specific card you want to play in your old dev card hand<br/>
	 * 		5. You have not yet played a non-monument dev card this turn<br/>
	 * 		6. You have enough monument cards to win the game (to reach 10 victory points)
	 * @post You gained a victory point
	 */
	public PlayMonumentCardOutput PlayMonumentCard(PlayMonumentCardInput input) throws ClientException;
}
