package communicators;

import java.io.*;
import java.net.*;

import server.ServerFacade;
import server.ServerProxy;
import shared.inputObjects.*;
import shared.outputObjects.*;

import com.sun.net.httpserver.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class ServerCommunicator {
	public static final ServerCommunicator SINGLETON = new ServerCommunicator();
	
	private static int SERVER_PORT_NUMBER = 8080;
	private static final int MAX_WAITING_CONNECTIONS = 10;
	
	private HttpServer server;
	private XStream xmlStream = new XStream(new DomDriver());
	
	private ServerCommunicator() {
		return;
	}
	
	/**
	 * Try creating and running the server
	 * @pre none
	 * @post The server will have started
	 */
	private void run() {
		
		try {
			server = HttpServer.create(new InetSocketAddress(SERVER_PORT_NUMBER),
											MAX_WAITING_CONNECTIONS);
		} 
		catch (IOException e) {
			System.out.println("Could not create HTTP server: " + e.getMessage());
			e.printStackTrace();
			return;
		}

		server.setExecutor(null); // use the default executor
		
		server.createContext("/" + ServerProxy.LOGIN_USER, loginUserHandler);
		server.createContext("/" + ServerProxy.REGISTER_USER, registerUserHandler);
		server.createContext("/" + ServerProxy.GET_LIST_OF_GAMES, getListOfGamesHandler);
		server.createContext("/" + ServerProxy.CREATE_GAME, createGameHandler);
		server.createContext("/" + ServerProxy.JOIN_GAME, joinGameHandler);
		server.createContext("/" + ServerProxy.SAVE_GAME, saveGameHandler);
		server.createContext("/" + ServerProxy.LOAD_GAME, loadGameHandler);
		server.createContext("/" + ServerProxy.UPDATE_GAME_STATE, updateGameStateHandler);
		server.createContext("/" + ServerProxy.RESET_GAME, resetGameHandler);
		server.createContext("/" + ServerProxy.GET_GAME_COMMANDS, getGameCommandsHandler);
		server.createContext("/" + ServerProxy.SET_GAME_COMMANDS, setGameCommandsHandler);
		server.createContext("/" + ServerProxy.GET_AI_TYPES, getAITypesHandler);
		server.createContext("/" + ServerProxy.ADD_AI_PLAYER, addAIPlayerHandler);
		server.createContext("/" + ServerProxy.SET_SERVER_LOG_LEVEL, setServerLogLevelHandler);
		server.createContext("/" + ServerProxy.SEND_CHAT, sendChatHandler);
		server.createContext("/" + ServerProxy.ACCEPT_TRADE, acceptTradeHandler);
		server.createContext("/" + ServerProxy.DISCARD_CARDS, discardCardsHandler);
		server.createContext("/" + ServerProxy.ROLL_DICE, rollDiceHandler);
		server.createContext("/" + ServerProxy.BUILD_ROAD, buildRoadHandler);
		server.createContext("/" + ServerProxy.BUILD_SETTLEMENT, buildSettlementHandler);
		server.createContext("/" + ServerProxy.BUILD_CITY, buildCityHandler);
		server.createContext("/" + ServerProxy.OFFER_TRADE, offerTradeHandler);
		server.createContext("/" + ServerProxy.MARITIME_TRADE, maritimeTradeHandler);
		server.createContext("/" + ServerProxy.ROB_PLAYER, robPlayerHandler);
		server.createContext("/" + ServerProxy.FINISH_TURN, finishTurnHandler);
		server.createContext("/" + ServerProxy.BUY_DEV_CARD, buyDevCardHandler);
		server.createContext("/" + ServerProxy.PLAY_SOLDIER_CARD, playSoldierCardHandler);
		server.createContext("/" + ServerProxy.PLAY_YEAR_OF_PLENTY_CARD, playYearOfPlentyCardHandler);
		server.createContext("/" + ServerProxy.PLAY_ROAD_BUILDING_CARD, playRoadBuildingCardHandler);
		server.createContext("/" + ServerProxy.PLAY_MONOPOLY_CARD, playMonopolyCardHandler);
		server.createContext("/" + ServerProxy.PLAY_MONUMENT_CARD, playMonumentCardHandler);
		
		server.start();
	}
	
	/**
	 * Start the server
	 * @pre none
	 * @post The server will have been started
	 */
	public void start() {
		SINGLETON.run();
	}
	
	/**
	 * Stop the server
	 * @pre The server is already on
	 * @post The server will have been stopped
	 */
	public void stop() {
		server.stop(1);
	}
	
	/**
	 * The HTTP handler for Logging in the user
	 * @returns An initialized handler for the login command
	 */
	private HttpHandler loginUserHandler = new HttpHandler() {
		/**
		 * The HTTP handler for Logging in the user
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the user will have been logged in, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			LoginUserOutput loginUserOutput = null;
			LoginUserInput input = (LoginUserInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				loginUserOutput = ServerFacade.SINGLETON.LoginUser(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(loginUserOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for registering a user
	 * @returns An initialized handler for the register command
	 */
	private HttpHandler registerUserHandler = new HttpHandler() {
		/**
		 * The HTTP handler for registering a user
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the user will have been registered, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			RegisterUserOutput registerUserOutput = null;
			RegisterUserInput input = (RegisterUserInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				registerUserOutput = ServerFacade.SINGLETON.RegisterUser(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(registerUserOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for getting a list of current games
	 * @returns An initialized handler for getting a list of current games
	 */
	private HttpHandler getListOfGamesHandler = new HttpHandler() {
		/**
		 * The HTTP handler for getting a list of current games
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, A list of current games will have been returned, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			CurrentGamesOutput currentGamesOutput = null;
			
			try {
				
				currentGamesOutput = ServerFacade.SINGLETON.GetCurrentListOfGames();
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(currentGamesOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for creating a game
	 * @returns An initialized handler for creating a game
	 */
	private HttpHandler createGameHandler = new HttpHandler() {
		/**
		 * The HTTP handler for creating a game
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a new game will have been created, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			CreateGameOutput createGameOutput = null;
			CreateGameInput input = (CreateGameInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				createGameOutput = ServerFacade.SINGLETON.CreateGame(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(createGameOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for joining a game
	 * @returns An initialized handler for joining a game
	 */
	private HttpHandler joinGameHandler = new HttpHandler() {
		/**
		 * The HTTP handler for joining a game
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a player will have joined a game, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			JoinGameOutput joinGameOutput = null;
			JoinGameInput input = (JoinGameInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				joinGameOutput = ServerFacade.SINGLETON.JoinGame(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(joinGameOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for saving a game
	 * @returns An initialized handler for saving a game
	 */
	private HttpHandler saveGameHandler = new HttpHandler() {
		/**
		 * The HTTP handler for saving a game
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the current game state will have been saved, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			SaveGameOutput saveGameOutput = null;
			SaveGameInput input = (SaveGameInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				saveGameOutput = ServerFacade.SINGLETON.SaveGame(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(saveGameOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for loading a game
	 * @returns An initialized handler for loading a game
	 */
	private HttpHandler loadGameHandler = new HttpHandler() {
		/**
		 * The HTTP handler for loading a game
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the specified game will have been loaded, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			LoadGameOutput loadGameOutput = null;
			LoadGameInput input = (LoadGameInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				loadGameOutput = ServerFacade.SINGLETON.LoadGame(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(loadGameOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for updating the current game state or model
	 * @returns An initialized handler for updating the current game state or model
	 */
	private HttpHandler updateGameStateHandler = new HttpHandler() {
		/**
		 * The HTTP handler for updating the current game state or model
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the updated model of the game will be returned (if not already up to date), otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			UpdateCurrentGameStateOutput updateCurrentGameStateOutput = null;
			UpdateCurrentGameStateInput input = (UpdateCurrentGameStateInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				updateCurrentGameStateOutput = ServerFacade.SINGLETON.UpdateCurrentGameState(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(updateCurrentGameStateOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for resetting a game
	 * @returns An initialized handler for resetting a game
	 */
	private HttpHandler resetGameHandler = new HttpHandler() {
		/**
		 * The HTTP handler for resetting a game
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the game will be reset to it's original state, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			ResetGameOutput resetGameOutput = null;
			ResetGameInput input = (ResetGameInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				resetGameOutput = ServerFacade.SINGLETON.ResetGame(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(resetGameOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for getting the commands that have been executed for the current game
	 * @returns An initialized handler for getting the commands that have been executed for the current game
	 */
	private HttpHandler getGameCommandsHandler = new HttpHandler() {
		/**
		 * The HTTP handler for getting the commands that have been executed for the current game
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the list of executed game commands will have been returned, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			GetCommandsForGameOutput getCommandsForGameOutput = null;
			
			try {
				
				getCommandsForGameOutput = ServerFacade.SINGLETON.GetCommandsForGame();
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(getCommandsForGameOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for setting the commands to be executed for the current game
	 * @returns An initialized handler for setting the commands to be executed for the current game
	 */
	private HttpHandler setGameCommandsHandler = new HttpHandler() {
		/**
		 * The HTTP handler for setting the commands to be executed for the current game
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the given commands will be executed for the current game, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			SetCommandsForGameOutput setCommandsForGameOutput = null;
			SetCommandsForGameInput input = (SetCommandsForGameInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				setCommandsForGameOutput = ServerFacade.SINGLETON.SetCommandsForGame(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(setCommandsForGameOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for getting the AITypes allowed
	 * @returns An initialized handler for getting the AITypes allowed
	 */
	private HttpHandler getAITypesHandler = new HttpHandler() {
		/**
		 * The HTTP handler for getting the AITypes allowed
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a list of allowed AI types will be returned, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			AITypesOutput getAITypesOutput = null;
			
			try {
				
				getAITypesOutput = ServerFacade.SINGLETON.GetAITypes();
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(getAITypesOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for adding an AI player
	 * @returns An initialized handler for adding an AI player
	 */
	private HttpHandler addAIPlayerHandler = new HttpHandler() {
		/**
		 * The HTTP handler for adding an AI player
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, an AI player will have been added to the game, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			AddAIPlayerOutput addAIPlayerOutput = null;
			AddAIPlayerInput input = (AddAIPlayerInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				addAIPlayerOutput = ServerFacade.SINGLETON.AddAIPlayer(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(addAIPlayerOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for setting the server log level
	 * @returns An initialized handler for setting the server log level
	 */
	private HttpHandler setServerLogLevelHandler = new HttpHandler() {
		/**
		 * The HTTP handler for setting the server log level
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the server log level will have been changed, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			ServerLogLevelOutput serverLogLevelOutput = null;
			ServerLogLevelInput input = (ServerLogLevelInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				serverLogLevelOutput = ServerFacade.SINGLETON.SetServerLogLevel(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(serverLogLevelOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for sending a message to the chat
	 * @returns An initialized handler for sending a message to the chat
	 */
	private HttpHandler sendChatHandler = new HttpHandler() {
		/**
		 * The HTTP handler for sending a message to the chat
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the message will have been displayed in the chat, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			SendChatOutput sendChatOutput = null;
			SendChatInput input = (SendChatInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				sendChatOutput = ServerFacade.SINGLETON.SendChat(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(sendChatOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for accepting a trade
	 * @returns An initialized handler for accepting a trade
	 */
	private HttpHandler acceptTradeHandler = new HttpHandler() {
		/**
		 * The HTTP handler for accepting a trade
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the trade will have been accepted, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			AcceptTradeOutput acceptTradeOutput = null;
			AcceptTradeInput input = (AcceptTradeInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				acceptTradeOutput = ServerFacade.SINGLETON.AcceptTrade(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(acceptTradeOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for discarding a player's cards
	 * @returns An initialized handler for discarding the player's cards
	 */
	private HttpHandler discardCardsHandler = new HttpHandler() {
		/**
		 * The HTTP handler for discarding a player's card
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a number of cards will have been discarded
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			DiscardCardsOutput discardCardsOutput = null;
			DiscardCardsInput input = (DiscardCardsInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				discardCardsOutput = ServerFacade.SINGLETON.DiscardCards(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(discardCardsOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for rolling the dice
	 * @returns An initialized handler for rolling the dice
	 */
	private HttpHandler rollDiceHandler = new HttpHandler() {
		/**
		 * The HTTP handler for rolling the dice
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the dice will be rolled and a random number will be given, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			RollDiceOutput rollDiceOutput = null;
			RollDiceInput input = (RollDiceInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				rollDiceOutput = ServerFacade.SINGLETON.RollDice(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(rollDiceOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for building a road
	 * @returns An initialized handler for building a road
	 */
	private HttpHandler buildRoadHandler = new HttpHandler() {
		/**
		 * The HTTP handler for building a road
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a road will have been built for the player, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			BuildRoadOutput buildRoadOutput = null;
			BuildRoadInput input = (BuildRoadInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				buildRoadOutput = ServerFacade.SINGLETON.BuildRoad(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(buildRoadOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for building a settlement
	 * @returns An initialized handler for building a settlement
	 */
	private HttpHandler buildSettlementHandler = new HttpHandler() {
		/**
		 * The HTTP handler for building a settlement
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a settlement will have been built, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			BuildSettlementOutput buildSettlementOutput = null;
			BuildSettlementInput input = (BuildSettlementInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				buildSettlementOutput = ServerFacade.SINGLETON.BuildSettlement(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(buildSettlementOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for building a city
	 * @returns An initialized handler for building a city
	 */
	private HttpHandler buildCityHandler = new HttpHandler() {
		/**
		 * The HTTP handler for building a city
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a city will have been built, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			BuildCityOutput buildCityOutput = null;
			BuildCityInput input = (BuildCityInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				buildCityOutput = ServerFacade.SINGLETON.BuildCity(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(buildCityOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for offering a trade
	 * @returns An initialized handler for offering a trade
	 */
	private HttpHandler offerTradeHandler = new HttpHandler() {
		/**
		 * The HTTP handler for offering a trade
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a trade will have been offered, otherwise an error will be return in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			OfferTradeOutput offerTradeOutput = null;
			OfferTradeInput input = (OfferTradeInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				offerTradeOutput = ServerFacade.SINGLETON.OfferTrade(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(offerTradeOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for trading with ports
	 * @returns An initialized handler for trading with ports
	 */
	private HttpHandler maritimeTradeHandler = new HttpHandler() {
		/**
		 * The HTTP handler for trading with ports
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the trade with ports occurred, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			MaritimeTradeOutput maritimeTradeOutput = null;
			MaritimeTradeInput input = (MaritimeTradeInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				maritimeTradeOutput = ServerFacade.SINGLETON.MaritimeTrade(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(maritimeTradeOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for robbing a player
	 * @returns An initialized handler for robbing a player
	 */
	private HttpHandler robPlayerHandler = new HttpHandler() {
		/**
		 * The HTTP handler for robbing a player
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a player will have been robbed of a random resource, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			RobPlayerOutput robPlayerOutput = null;
			RobPlayerInput input = (RobPlayerInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				robPlayerOutput = ServerFacade.SINGLETON.RobPlayer(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(robPlayerOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for finishing a player's turn
	 * @returns An initialized handler for finishing a player's turn
	 */
	private HttpHandler finishTurnHandler = new HttpHandler() {
		/**
		 * The HTTP handler for finishing a player's turn
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the player's turn will have finished and it will be the next player's turn, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			FinishTurnOutput finishTurnOutput = null;
			FinishTurnInput input = (FinishTurnInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				finishTurnOutput = ServerFacade.SINGLETON.FinishTurn(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(finishTurnOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for buying a development card
	 * @returns An initialized handler for buying a development card
	 */
	private HttpHandler buyDevCardHandler = new HttpHandler() {
		/**
		 * The HTTP handler for buying a development card
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a development card will now be in the player's deck, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			BuyDevCardOutput buyDevCardOutput = null;
			BuyDevCardInput input = (BuyDevCardInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				buyDevCardOutput = ServerFacade.SINGLETON.BuyDevCard(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(buyDevCardOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for playing a soldier card
	 * @returns An initialized handler for playing a soldier card
	 */
	private HttpHandler playSoldierCardHandler = new HttpHandler() {
		/**
		 * The HTTP handler for playing a soldier card
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, the soldier card will have been played, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			PlaySoldierCardOutput playSoldierCardOutput = null;
			PlaySoldierCardInput input = (PlaySoldierCardInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				playSoldierCardOutput = ServerFacade.SINGLETON.PlaySoldierCard(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(playSoldierCardOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for playing a year of plenty card
	 * @returns An initialized handler for playing a year of plenty card
	 */
	private HttpHandler playYearOfPlentyCardHandler = new HttpHandler() {
		/**
		 * The HTTP handler for playing a year of plenty card
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a year of plenty card will have been played, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			PlayYearOfPlentyCardOutput playYearOfPlentyCardOutput = null;
			PlayYearOfPlentyCardInput input = (PlayYearOfPlentyCardInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				playYearOfPlentyCardOutput = ServerFacade.SINGLETON.PlayYearOfPlentyCard(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(playYearOfPlentyCardOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for playing a road building card
	 * @returns An initialized handler for playing a road building card
	 */
	private HttpHandler playRoadBuildingCardHandler = new HttpHandler() {
		/**
		 * The HTTP handler for playing a road building card
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a road building card will have been played, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
		
			PlayRoadBuildingCardOutput playRoadBuildingCardOutput = null;
			PlayRoadBuildingCardInput input = (PlayRoadBuildingCardInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				playRoadBuildingCardOutput = ServerFacade.SINGLETON.PlayRoadBuildingCard(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(playRoadBuildingCardOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for playing a monopoly card
	 * @returns An initialized handler for playing a monopoly card
	 */
	private HttpHandler playMonopolyCardHandler = new HttpHandler() {
		/**
		 * The HTTP handler for playing a monopoly card
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a monopoly card will have been played, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			PlayMonopolyCardOutput playMonopolyCardOutput = null;
			PlayMonopolyCardInput input = (PlayMonopolyCardInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				playMonopolyCardOutput = ServerFacade.SINGLETON.PlayMonopolyCard(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(playMonopolyCardOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The HTTP handler for playing a monument card
	 * @returns An initialized handler for playing a monument card
	 */
	private HttpHandler playMonumentCardHandler = new HttpHandler() {
		/**
		 * The HTTP handler for playing a monument card
		 * @throws IOException
		 * @pre exchange is not null
		 * @post If successful, a monument card will have been played and a player may have enough points to win the game, otherwise an error will be returned in the response
		 */
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			
			PlayMonumentCardOutput playMonumentCardOutput = null;
			PlayMonumentCardInput input = (PlayMonumentCardInput)xmlStream.fromXML(exchange.getRequestBody());
			
			try {
				
				playMonumentCardOutput = ServerFacade.SINGLETON.PlayMonumentCard(input);
			}
			catch (Exception e) { // FileNotFoundException | ServerException
				System.out.println(e.getMessage());
				e.printStackTrace();
				exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, -1);
				return;
			}
			
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
			xmlStream.toXML(playMonumentCardOutput, exchange.getResponseBody());
			exchange.getResponseBody().close();
		}
	};
	
	/**
	 * The main method to run the server from the command line
	 * @param args The given parameters for using specific ports
	 * @pre none
	 * @post The server will be started and if a port is specified, it will be run on that port
	 */
	public static void main(String[] args) {

		if (args.length > 0) {
			
			SERVER_PORT_NUMBER = Integer.parseInt(args[0]);
		}
		SINGLETON.run();
	}
}
