package com.company;

import java.util.Scanner;

public class Main {

    // items to be used in all the rooms
    static int scissors = 0;
    static int lighter = 1;
    static int socks = 0;
    static int roomKey = 1;

    static int greenLock = 0;            // Condition of the green door
    static int exitLevelZero = 0;        // Game ends when exitLevelZero = 1


    public static void gameIntro() {
        System.out.println("########################");
        System.out.println("# WELCOME TO LEVELZERO #");
        System.out.println("########################");
        try {
            Thread.sleep(700);
            System.out.println("Your game will start in..");
            Thread.sleep(700);
            System.out.println(3);
            Thread.sleep(1000);
            System.out.println(2);
            Thread.sleep(1000);
            System.out.println(1);
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //gameIntro();

        System.out.println("You are standing in a dark room, all you can see is three glowy doors: yellow, orange and green");

        int key = 0;
        while (key == 0) {

            if (exitLevelZero == 1) {            // exitLevelZero == 1 is the end condition of the game
                return;
            }
            System.out.println("keywords are: open, yellow, orange, green.");
            Scanner scanner = new Scanner(System.in);
            String door = scanner.nextLine();

            // YELLOW DOOR
            if (door.equals("open yellow")) {
                yellowDoor(scanner);
            }
            // ORANGE DOOR
            else if (door.equals("open orange")) {
                orangeDoor(scanner);
            }
            // GREEN DOOR
            else if (door.equals("open green")) {
                greenDoor(scanner);
            } else {
                System.out.println("try another order");
            }
        }
    }

    // while loops in order for the user to give other orders
    // scanners take input from user
    // 'if's compare the input of the user to choose which path to go
    // 'back's move one while loop behind
    // 'exit's move the user back to the 3 doors


    // Yellow Door
    public static void yellowDoor(Scanner scanner) {
        System.out.println("You entered the room. You see a quite man and a worried woman, it's your chance to make friends!");

        int yellowKey = 0;
        while (yellowKey == 0) {
            System.out.println("keywords: talk to, explore, exit, man, woman, room");
            String yellow = scanner.nextLine();

            if (yellow.equals("explore room")) {
                System.out.println("In the drawers you found a pair of scissors, a lighter, and some old socks");
                System.out.println("keywords: take, scissors, lighter, socks, back");

                // gathering items from the orange room
                int exploreKey = 0;
                while (exploreKey == 0) {
                    String items = scanner.nextLine();
                    if (items.equals("take scissors")) {
                        System.out.println("taken");
                        scissors = 1;
                    } else if (items.equals("take lighter")) {
                        System.out.println("taken");
                        lighter = 1;
                    } else if (items.equals("take socks")) {
                        System.out.println("taken");
                        socks = 1;
                    } else if (items.equals("back")) {
                        exploreKey = 1;
                    } else if (items.equals("exit") || items.equals("exit room")) {
                        System.out.println("you are back to the room with the doors, yellow, orange and green");
                        exploreKey = 1;
                        yellowKey = 1;
                    } else {
                        System.out.println("try another order");
                    }
                }
            }
            // Dialog 1
            else if (yellow.equals("talk to man")) {

                System.out.println("Player: Where am I?");
                System.out.println("Man: In the room with the yellow door");
                System.out.println("Player: No I mean in general! how can I get out?");
                System.out.println("Man: Just 'exit' your way out man");
                System.out.println("Player: uh.. what??");
                System.out.println("Man: DON'T YOU GET IT! IT'S NONE DIMENSIONAL");
                System.out.println("Player: I.. ");
                System.out.println("Man: DO YOU EVEN CHOOSE YOUR OWN WORDS?");
                System.out.println("\n ...the man got out of control, try another order");

            }
            // Dialog 2
            else if (yellow.equals("talk to woman")) {
                System.out.println("Woman: sorry young man, if I help you they might remove me from the..");
                System.out.println("Player: remove you! what the hell is that supposed to mean?!");
                System.out.println("Woman: Look young man I've already said too much. Just keep that in mind: " +
                        "computers only understand ones and zeros. I can't tell you more than that\n");

            } else if (yellow.equals("exit room") || yellow.equals("exit")) {
                System.out.println("you are back to the room with the doors, yellow, orange and green");
                yellowKey = 1;

            } else {
                System.out.println("try another order");
            }
        }
    }

    // Orange Door
    public static void orangeDoor(Scanner scanner) {
        int orangeKey = 0;
        System.out.println("You entered the room, but it's so dark you can't see anything!");


        while (orangeKey == 0) {
            System.out.println("Keywords: figure it out!");
            String orange = scanner.nextLine();

            // Checks if user gathered the lighter from the other room in order to use it
            if (lighter == 0 && orange.equals("use lighter")) {
                System.out.println("you don't have a lighter");
            } else if (orange.equals("use light")) {
                System.out.println("light is broken");
            } else if (lighter == 1 && orange.equals("use lighter")) {
                System.out.println("Impressive! now that you can see what's around you, you can navigate the room");

                // Moving around in the Orange room
                int orientationKey = 0;
                while (orientationKey == 0) {
                    System.out.println("keywords: go to, north, east, west, back, exit");
                    String orientation = scanner.nextLine();

                    // North
                    if (orientation.equals("go to north")) {
                        System.out.println("You step on a sketchy rug, in front of an old sofa");

                        int north = 0;
                        while (north == 0) {
                            System.out.println("Keywords: check, exit, under, rug, room");
                            String rug = scanner.nextLine();
                            if (rug.equals("check under rug")) {
                                if (roomKey == 0) {
                                    System.out.println("under the rug you find a key and much of dirt");

                                    int underRug = 0;
                                    while (underRug == 0) {
                                        System.out.println("Keywords: take, key");
                                        String takeKey = scanner.nextLine();
                                        if (takeKey.equals("take key")) {
                                            System.out.println("taken");
                                            roomKey = 1;
                                            underRug = 1;
                                            north = 1;

                                        } else if (takeKey.equals("back")) {
                                            underRug = 1;
                                        } else if (takeKey.equals("exit room") || takeKey.equals("exit")) {
                                            System.out.println("you are back to the room with the doors, yellow, orange and green");
                                            underRug = 1;
                                            orientationKey = 1;
                                            orangeKey = 1;
                                            north = 1;
                                        } else {
                                            System.out.println("try another order");
                                        }
                                    }
                                }
                                else {      // Key already taken
                                    System.out.println("dirt, and only dirt.");
                                    north = 1;
                                }
                            } else if (rug.equals("back")) {
                                north = 1;
                            } else if (rug.equals("exit room") || rug.equals("exit")) {
                                System.out.println("you are back to the room with the doors, yellow, orange and green");
                                orientationKey = 1;
                                orangeKey = 1;
                                north = 1;
                            } else {
                                System.out.println("try another order");
                            }
                        }
                    }
                    // South
                    else if (orientation.equals("go to south")) {
                        System.out.println("You are by the door");
                    }
                    // East
                    else if (orientation.equals("go to east")) {
                        System.out.println("You see a crooked painting on the wall");
                        int eastKey = 0;
                        while (eastKey == 0) {
                            System.out.println("Keywords: remove, exit, painting, room ,back");
                            String painting = scanner.nextLine();
                            if (painting.equals("remove painting")) {
                                System.out.println("on the back of the painting you find a piece of paper with the following note:" +
                                        " \"PASSWORD: three\"");
                                eastKey = 1;

                            } else if (painting.equals("back")) {
                                eastKey = 1;
                            } else if (painting.equals("exit room") || painting.equals("exit")) {
                                System.out.println("you are back to the room with the doors, yellow, orange and green");
                                eastKey = 1;
                                orientationKey = 1;
                                orangeKey = 1;
                            } else {
                                System.out.println("try another order");
                            }
                        }
                    }
                    // West
                    else if (orientation.equals("go to west")) {
                        System.out.println("You only see smelly garbage, nothing interesting here!");
                    } else if (orientation.equals("back")) {
                        orientationKey = 1;
                    } else if (orientation.equals("exit room") || orientation.equals("exit")) {
                        System.out.println("you are back to the room with the doors, yellow, orange and green");
                        orientationKey = 1;
                        orangeKey = 1;
                    } else {
                        System.out.println("try another order");
                    }
                }
            } else if (orange.equals("exit") || orange.equals("exit room")) {
                System.out.println("you are back to the room with the doors, yellow, orange and green");
                orangeKey = 1;
            } else {
                System.out.println("try another order");
            }
        }
    }

    // Green Door
    public static void greenDoor(Scanner scanner) {

        int keyLock = 0;
        while (keyLock == 0) {

            // if/else prevents the output "Green door is locked" if the door has previously been opened
            String lock;
            if (greenLock == 0) {
                System.out.println("Green door is locked");
                System.out.println("Keywords: use, back, key");

                lock = scanner.nextLine();
            } else {
                lock = "use key";
            }


            if (lock.equals("use key") && roomKey == 1) {

                greenLock = 1;
                System.out.println("You entered the room, all you see is a laptop and a door with a huge lock. " +
                        "It looks like this room is your way out!");
                int greenKey = 0;

                while (greenKey == 0) {
                    System.out.println("Keywords: use, open, back, exit, lock, laptop, room");
                    String green = scanner.nextLine();

                    if (green.equals("use laptop") || green.equals("open laptop")) {
                        System.out.println("Enter the Password, or write 'back' to leave the laptop\nHint: password of 4 numbers");

                        int enterPass = 0;
                        while (enterPass == 0) {
                            String password = scanner.nextLine();
                            if (password.equals("0011")) {                // Password: 3 in binary
                                System.out.println("on the Desktop you see the following programs:");
                                System.out.println("LevelZero.java, readMe.txt, Recycle Bin");

                                int desktop = 0;
                                while (desktop == 0) {


                                    System.out.println("Keywords: open, back, exit, read me, levelzero, recycle bin, room");

                                    String programs = scanner.nextLine();
                                    // LevelZero.java
                                    if (programs.equals("open levelzero")) {
                                        System.out.println("\n\npublic class LevelZero {\n  public static void main(String[] args){\n\n      int exitLevelZero = 0;\n      " +
                                                "boolean playerIsTrapped = true;\n" +
                                                "    while(exitLevelZero == 0){\n\n      }\n      playerIsTrapped = false;\n  }\n}");

                                        int deepestWhile = 0;
                                        while (deepestWhile == 0) {
                                            String last = scanner.nextLine();
                                            if (last.equals("exitLevelZero++;") || last.equals("exitLevelZero = 1;") || last.equals("exitLevelZero=1;")
                                                    || last.equals("playerIsTrapped=false;") || last.equals("playerIsTrapped = false;")) {
                                                System.out.println(".\n====================================================================");
                                                System.out.println("Congrats! you figured your way out of LevelZero!\n==================================" +
                                                        "==================================\n.");
                                                try {
                                                    Thread.sleep(1000);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }
                                                System.out.println("Now back to the Real game" +
                                                        ", do you have a clue? this one is THREE DIMENSIONAL!");
                                                exitLevelZero++;
                                                return;
                                            } else if (last.equals("back")) {
                                                deepestWhile = 1;
                                            } else if (last.equals("exit") || last.equals("exit room")) {
                                                System.out.println("you are back to the room with the doors, yellow, orange and green");
                                                deepestWhile = 1;
                                                desktop = 1;
                                                enterPass = 1;
                                                greenKey = 1;
                                            } else {
                                                System.out.println("try another order");
                                            }
                                        }
                                    }
                                    // readMe.txt
                                    else if (programs.equals("open read me")) {
                                        System.out.println("\"You will be missed. (not really)\"");

                                        int readMeKey = 0;
                                        while (readMeKey == 0) {
                                            System.out.println("Keywords: back, exit, room");
                                            String quitReadMe = scanner.nextLine();
                                            if (quitReadMe.equals("back")) {
                                                readMeKey = 1;
                                            } else if (quitReadMe.equals("exit") || quitReadMe.equals("exit room")) {
                                                System.out.println("you are back to the room with the doors, yellow, orange and green");
                                                readMeKey = 1;
                                                desktop = 1;
                                                enterPass = 1;
                                                greenKey = 1;
                                            } else {
                                                System.out.println("try another order");
                                            }
                                        }

                                    }
                                    // Recycle Bin
                                    else if (programs.equals("open recycle bin")) {
                                        System.out.println("*empty folder*");

                                        int binKey = 0;
                                        while (binKey == 0) {
                                            System.out.println("Keywords: back, exit, room");
                                            String quitReadMe = scanner.nextLine();
                                            if (quitReadMe.equals("back")) {
                                                binKey = 1;
                                            } else if (quitReadMe.equals("exit") || quitReadMe.equals("exit room")) {
                                                System.out.println("you are back to the room with the doors, yellow, orange and green");
                                                binKey = 1;
                                                desktop = 1;
                                                enterPass = 1;
                                                greenKey = 1;
                                            }
                                        }
                                    } else if (programs.equals("back")) {
                                        desktop = 1;
                                    } else {
                                        System.out.println("try another order");
                                    }
                                }

                            } else if (password.equals("back")) {
                                enterPass = 1;
                            } else {
                                System.out.println("wrong password, try something else");
                            }
                        }
                    } else if (green.equals("open lock")) {
                        System.out.println("your key doesn't fit");

                    } else if (green.equals("exit room") || green.equals("exit")) {
                        System.out.println("you are back to the room with the doors, yellow, orange and green");
                        greenKey = 1;
                    } else {
                        System.out.println("try another order");
                    }
                }
                keyLock = 1;
            } else if (lock.equals("use key") && roomKey == 0) {
                System.out.println("you don't have the key");
                keyLock = 1;
            } else if (lock.equals("back")) {
                System.out.println("you are back to the room with the doors, yellow, orange and green");
                break;
            } else {
                System.out.println("try another order");
            }
        }
    }
}
