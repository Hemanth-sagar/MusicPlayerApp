package com.hemanth;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    private static ArrayList<Album> albums=new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1","Justin");

        album.addSong("Sorry",3.5);
        album.addSong("Peaches",5.5);
        album.addSong("Let me Love You",3.5);
        albums.add(album);

        album = new Album("Album2","DJSnake");
        album.addSong("Taki Taki",3.5);
        album.addSong("Magenta Riddim",5.5);
        album.addSong("Let me Love You",3.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Sorry",playList_1);
        albums.get(0).addToPlayList("Peaches",playList_1);
        albums.get(1).addToPlayList("Taki Taki",playList_1);
        albums.get(1).addToPlayList("Let me Love You",playList_1);

        play(playList_1);

    }

    private static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator=playlist.listIterator();

        if(playlist.size() == 0){
            System.out.println("This playlist have no song");
        }
        else{
            System.out.println("Now playing "+listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist completed");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }
                    else{
                        System.out.println("no song available,reached to end");
                        forward = false;
                    }
                    break;
                   //Implementing
                case 2:
                    if(forward){

                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available options in music player\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs\n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator= playList.iterator();
        System.out.println("-----------------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-----------------------------");
    }
}