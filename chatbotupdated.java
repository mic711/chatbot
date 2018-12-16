public class Chatbot{

String welcome = (agent) ->
  agent.add ("Welcome to my agent!");
  {
  return;

fallback = (agent) ->
  agent.add ("I did not understand");
  agent.add ("I am sorry, can you try again?");
  {
  return;

 // below to get this function to be run when intent is matched

yourFunctionHandler = (agent) ->
  agent.add ("This message is from Dialogflow\'s Cloud Functions for Firebase editor!");
  agent.add (new Card(title,imageUrl,text,buttonText,buttonUrl));
  agent.add (new Suggestion("Quick Reply"));
  agent.add (new Suggestion("Suggestion"));
  agent.setContext(name, lifespan, city);
    {
  return;

// below to get this function to be run when intent is matched

googleAssistantHandler = (agent) ->
  conv = agent.conv();
  // Get Actions on Google library conv instance
  conv.add ("Hello from the Actions on Google client library!");
  //Use Actions on Google library
  agent.add (conv);
  // Add Actions on Google library responses to your agent's response
  {
  return;

//"use strict";
functions = require("firebase-functions");
WebhookClient = require("dialogflow-fulfillment");
Card_Suggestion = require("dialogflow-fulfillment");
process.env.DEBUG = "dialogflow:debug";
// enables lib debugging statements
exports.dialogflowFirebaseFulfillment = functions.https.onRequest(requestresponse);
agent = (new WebhookClient(request, response));
console.log ("Dialogflow Request headers: " + JSON.stringify(request.headers));
console.log ("Dialogflow Request body: " + JSON.stringify(request.body));
intentMap.set ("your intent name here", yourFunctionHandler);
intentMap.set ("your intent name here", googleAssistantHandler);

// Run the proper function handler based on the intent name
intentMap = new Map [
intentMap.set ("Default Welcome Intent", welcome)];
intentMap.set ("Default Fallback Intent", fallback);
//intentMap.set("your intent name here", yourFunctionHandler)
//intentMap.set("your intent name here", googleAssistantHandler)
agent.handleRequest intentMap;
}
}
}
}
}
