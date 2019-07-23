/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentreportcard;

import java.util.Scanner;

public class StudentReportCard {

    public static void main(String[] args) {
        showMenu("");

    }

    public static void showMenu(String fileName) throws NumberFormatException {
        String students[][] = new String[5][2];

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n\n|--------------------------------------------------------|");
            System.out.println("|    Welcome to Hong Software (copyrighted!)          |");
            System.out.println("|--------------------------------------------------------|");

            System.out.println("\nPlease Make a selection:");
            System.out.println("\t[1] Add a new student");
            System.out.println("\t[2] Display student");
            System.out.println("\t[3] Average score");
            System.out.println("\t[4] Lowest scores");
            System.out.println("\t[5] Highest Score");
            System.out.println("\t[6] Search score");
            System.out.println("\t[7] Display report card letter grade");
            System.out.println("\t[8] Delete Student");
            System.out.println("\t[9] Change score");
            System.out.println("\t[10] Change name");
            System.out.println("\t[18] exit");
            System.out.println("------------------------------------------------------------");

            System.out.println("Selection: ");
            int selection = scanner.nextInt();

            if (selection == 18) {
                // exit if selection = 3
                break;
            }

            if (selection == 1) {
                System.out.println("Adding new record");
                addStudent(students);
            } else if (selection == 2) {
                System.out.println("Display Student");
                displayStudents(students);

            } else if (selection == 3) {
                System.out.println("Average score is ");
                calculateAverage(students);
            } else if (selection == 4) {
                System.out.println("The lowest score is ");
                calculatelowest(students);
            } else if (selection == 5) {
                System.out.println("The highest score is ");
                calculateHighest(students);
            } else if (selection == 6) {
                System.out.println("The name you searched for is ");
                System.out.println("Please enter the name you want to change ");
                String name = scanner.nextLine();
                searchByName(students, name);
            } else if (selection == 7) {
                System.out.println("The letter grade this students has is ");
                printLetterGrade(students);

            } else if (selection == 9) {
                System.out.println("The score changed to ");
                changeScore(students);
            } else if (selection == 8) {
                System.out.println("The student that was deleted is ");
                deleteStudent(students);
            } else if (selection == 10) {
                System.out.println("The student's name changed to ");
                changeName(students);
            } else {

                System.out.println("Please enter a valid selection.");

            }
        }

    }

    public static void changeName(String[][] students) {
        int rownumber = -1;
        boolean foundIt = false;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter the name you want to change ");
        String name = scanner2.nextLine();
        rownumber = searchByName(students, name);

        if (rownumber == -1) {
            System.out.println(name + " is not found");
        } else {

            foundIt = true;
            System.out.println("Please enter the new name for " + name);
            String newname = scanner2.nextLine();
            String oldname = students[rownumber][0];
            students[rownumber][0] = newname;
            System.out.println(name + " 's name is now changed from " + oldname + " to " + newname);

        }
    }

    public static void changeScore(String[][] students) {
        int rownumber = -1;
        boolean foundIt = false;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter the name you want to change the score");
        String name = scanner2.nextLine();
        rownumber = searchByName(students, name);

        if (rownumber == -1) {
            System.out.println(name + " is not found");
        } else {

            foundIt = true;
            System.out.println("Please enter new score for " + name);
            String newscore = scanner2.nextLine();
            String oldscore = students[rownumber][1];
            students[rownumber][1] = newscore;
            System.out.println(name + "'s score is now changed from " + oldscore + " to " + newscore);

        }
    }

    public static void deleteStudent(String[][] students) {
        int rownumber = -1;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter the name you want deleted");
        String name = scanner2.nextLine();
        boolean foundIt = false;
        rownumber = searchByName(students, name);
        if (rownumber == -1) {
            System.out.println(name + " isn't in this report card. Please type again.");
        } else {

            students[rownumber][0] = null;
            students[rownumber][1] = null;
            System.out.println(name + " is deleted from the report card");

        }
    }

    public static void printLetterGrade(String[][] students) {
        String letter;

        for (int i = 0; i < students.length; i++) {
            if (students[i][0] != null) {

                double score = Double.parseDouble(students[i][1]);

                if ((score <= 100) && (score >= 90)) {
                    letter = "A";
                } else if ((score <= 89) && (score >= 80)) {
                    letter = "B";
                } else if ((score <= 79) && (score >= 70)) {
                    letter = "C";
                } else if ((score <= 69) && (score >= 60)) {
                    letter = "D";
                } else {
                    letter = "F!";
                }
                System.out.println(students[i][0] + " has a score of " + score + " and a grade of " + letter);
            }
        }

    }

    public static int searchByName(String[][] students, String name) {

        int mylocation = -1;

        boolean foundIt = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i][0] != null) {
                if (students[i][0].equals(name)) {
                    foundIt = true;
                    mylocation = i;
                    break;
                }
            }
        }
        if (mylocation != -1) {
            System.out.println(name + " has a score of " + students[mylocation][1]);
        } else {
            System.out.println("The name " + name + " is not found");
        }
        return mylocation;
    }

    public static void calculatelowest(String[][] students) {
        double lowest = 0;
        String name = null;
        for (int i = 0; i < students.length; i++) {
            if (students[i][0] != null) {

                double score = Double.parseDouble(students[0][1]);
                lowest = score;
                name = students[i][0];
                break;
            }
        }

        for (int i = 1; i < students.length; i++) {
            if (students[i][0] != null) {

                double score = Double.parseDouble(students[i][1]);
                if (lowest > score) {
                    name = students[i][0];
                    lowest = score;
                }
            }

        }
        System.out.println(name + " has a score of " + lowest);
    }

    public static void calculateHighest(String[][] students) {
        double highest = 0;
        String name = null;
        for (int i = 0; i < students.length; i++) {
            if (students[i][0] != null) {
                double score = Double.parseDouble(students[i][1]);
                if (highest < score) {
                    name = students[i][0];
                    highest = score;
                }
            }
        }
        System.out.println(name + " has a score of " + highest);
    }

    public static void calculateAverage(String[][] students) {
        double total = 0;
        int numbrofstudents = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i][1] != null) {
                numbrofstudents = numbrofstudents + 1;
                double score = Double.parseDouble(students[i][1]);
                total = total + score;
            }

        }
        double average = 0;
        average = total / numbrofstudents;
        System.out.println("The average score of this class " + average);
    }

    public static void displayStudents(String[][] students) {
        for (int i = 0; i < students.length; i++) {
            String name = students[i][0];
            String score = students[i][1];
            if (name != null) {

                System.out.println(name + "has a score of " + score);

            }
        }
    }

    public static String[][] addStudent(String[][] students) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter a student name>");
        String name = scanner2.nextLine();
        System.out.println("what is the score for " + name + "?");
        String score = scanner2.nextLine();

        for (int i = 0; i < students.length; i++) {
            if (null == students[i][0]) {
                students[i][0] = name;
                students[i][1] = score;
                break;
            }
        }

        return students;
    }

}
