package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import controllers.IdController;
import controllers.MessageController;
import controllers.TransactionController;
import models.Id;
import models.Message;

public class SimpleShell {
    public static void main(String[] args) throws java.io.IOException {
        TransactionController transactionCtrl =
                new TransactionController(new MessageController(), new IdController());

        String commandLine;
        BufferedReader console = new BufferedReader
                (new InputStreamReader(System.in));

        ProcessBuilder pb = new ProcessBuilder();
        List<String> history = new ArrayList<String>();
        int index = 0;

        while (true) {
            // read what the user enters
            System.out.println("\ncmd? ");
            commandLine = console.readLine();

            // input is parsed into an array of strings (command and arguments)
            String[] commands = commandLine.split(" ");
            commands[0] = commands[0].toLowerCase();

            // if the user entered a return, just loop again
            if (commandLine.equals(""))
                continue;
            // if the user types exit, the loop breaks
            if (commandLine.equals("exit")) {
                System.out.println("bye!");
                break;
            }

            List<String> list = new ArrayList<String>();
            Collections.addAll(list, commands);
            //System.out.print(list); //***check to see if list was added correctly***
            history.addAll(list);

            try {
                // TODO test history?
                //display history of shell with index
                if (list.get(list.size() - 1).equals("history")) {
                    for (String s : history)
                        System.out.println((index++) + " " + s);
                    continue;
                }

                /*
                -------------------------
                    SPECIFIC COMMANDS
                -------------------------

                    IDS COMMAND
                 */
                if (list.get(0).equals("ids")) {
                    if (list.size() == 1) {
                        // call GET /ids and print results
                        Console.prettyListPrint(transactionCtrl.getIdCtrl().getIdsAsList());
                    } else if (list.size() == 3) {
                        // POST or PUT the name and ID
                        Id newId = new Id(list.get(1), list.get(2));

                        // if ID exists
                        if (transactionCtrl.getIdCtrl().idExists(newId)) {
                            String userId = transactionCtrl.getIdCtrl().getUserId(newId);
                            // and username is different, PUT it
                            if (!transactionCtrl.getIdCtrl().getIdByUserId(userId).getName()
                                    .equals(newId.getName())) {
                                newId.setUserid(userId);
                                transactionCtrl.getIdCtrl().putId(newId);
                                System.out.println("Username updated.");
                            } else {
                                System.out.println("Id and username already exist.");
                            }
                        } else { // else if ID doesn't exist, POST it
                            transactionCtrl.getIdCtrl().postId(newId);
                            System.out.println("ID posted successfully.");
                        }

                    } else {
                        Console.println("type 'ids' for a list of all ids\n" +
                                "type 'ids your_name your_github_id' to add or change" +
                                "your ID\n");
                    }
                    continue;
                }

                /*
                    MESSAGES COMMAND
                 */
                if (list.get(0).equals("messages")) {
                    if (list.size() == 1) {
                        // call GET /messages and print results
                        Console.prettyListPrint(transactionCtrl.getMsgCtrl().getMessages());
                    } else if (list.size() == 2) {
                        // if ID name exists, get 20 messages addressed to that ID
                        if (transactionCtrl.getIdCtrl().idExists(new Id("", list.get(1)))) {
                            List<Message> messagesForId = transactionCtrl.getMsgCtrl().getMessagesForId(list.get(1));
                            if (messagesForId == null) Console.println("No messages for you, sorry.");
                            else {
                                Console.prettyListPrint(messagesForId);
                            }
                        } else {
                            Console.println("That Github ID is not registered.");
                        }
                    } else {
                        Console.println("type 'messages' for a list of last 20 messages\n" +
                                "type 'messages your_github_id' to last 20 messages addressed" +
                                " to that Github ID\n");
                    }
                    continue;
                }

                /*
                    SEND COMMAND
                */
                if (list.get(0).equals("send")) {
                    Message message = new Message();
                    message.setFromId(list.get(1));
                    // if message to be posted openly
                    if (list.get(2).startsWith("'") && list.get(list.size() - 1).endsWith("'")) {
                        message.setMessage(String.join(" ", list.subList(2, list.size())));
                        Console.prettyPrint(transactionCtrl.getMsgCtrl().postMessage(message));
                    // else if message to be posted to a specific recipient
                    } else if (list.get(2).startsWith("'") && list.get(list.size() - 3).endsWith("'")
                        && list.get(list.size() - 2).equals("to")) {
                        message.setToId(list.get(list.size() - 1));
                        message.setMessage(String.join(" ", list.subList(2, list.size() - 2)));
                        Console.prettyPrint(transactionCtrl.getMsgCtrl().postMessage(message));
                    } else {
                        Console.println("type 'send your_github_id message' to send a message to all\n" +
                                "type 'send your_github_id message to friend_github_id' to address a message to a particular user");
                    }
                    continue;
                }



                // !! command returns the last command in history
                if (list.get(list.size() - 1).equals("!!")) {
                    pb.command(history.get(history.size() - 2));

                }// !<integer value i> command
                else if (list.get(list.size() - 1).charAt(0) == '!') {
                    int b = Character.getNumericValue(list.get(list.size() - 1).charAt(1));
                    if (b <= history.size())//check if integer entered isn't bigger than history size
                        pb.command(history.get(b));
                } else {
                    pb.command(list);
                    throw new IOException("IO Exception?");
                }

                // // wait, wait, what curiousness is this?
                // Process process = pb.start();

                // //obtain the input stream
                // InputStream is = process.getInputStream();
                // InputStreamReader isr = new InputStreamReader(is);
                // BufferedReader br = new BufferedReader(isr);

                // //read output of the process
                // String line;
                // while ((line = br.readLine()) != null)
                //     System.out.println(line);
                // br.close();

            }

            //catch ioexception, output appropriate message, resume waiting for input
            catch (IOException e) {
                System.out.println("Input Error, Please try again!");
            }
            // So what, do you suppose, is the meaning of this comment?
            /* The steps are:
             * 1. parse the input to obtain the command and any parameters
             * 2. create a ProcessBuilder object
             * 3. start the process
             * 4. obtain the output stream
             * 5. output the contents returned by the command
             */

        }

    }

}