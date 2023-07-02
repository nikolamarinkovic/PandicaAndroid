package com.example.pandica_anroid.Models;

import com.example.pandica_anroid.R;

import java.util.LinkedList;
import java.util.List;

public class Event {

    public static List<Event> events;

    static {
        events = new LinkedList<>();

        Event penguinsFromMadagascar = new Event(0, "Pingvini sa Madagaskara", "Poseta poznate pingvinske cetvorke sa Madagaskara: Majora, Rika, Vojnika, Kovalskog. Dodjite i upoznajte se sa ovim legendama Madagaskara.",
                new LinkedList<>(), R.drawable.event_0);

        Event sheepDolly = new Event(0, "Ovca Dolly dolazi ovog vikenda", "Ovca dolly, prva ovca koja je klonirana, dolazi da vas poseti, dodjite da vidite moc kloniranja!",
                new LinkedList<>(), R.drawable.event_1);

        Event gorillaHarambe = new Event(0, "Gorila Harambe", "Najpoznatija gorila na svetu je odlucila da zeli da poseti Vas, nemojte propustiti ovu jedinstvenu priliku!",
                new LinkedList<>(), R.drawable.event_2);

        Event underwaterExtravaganza = new Event(0, "Podvodna ekstravaganza", "Samo sledeceg vikenda, otvaramo podvodni region za pregled svima, imacemo na uvid sve sto morski zivot moze da ponudi!",
                new LinkedList<>(), R.drawable.event_3);

        Event africanParty = new Event(0, "Africka zurka", "Africko ludilo se siri i u Srbiji, dodjite da vidite sve sto Africki zivot moze da ponudi.",
                new LinkedList<>(), R.drawable.event_4);

        Event asianMania = new Event(0, "Azijsko ludilo", "Azija ima veoma bujni zivotinjski zivot, sledeceg vikenda nemojte propustiti priliku!",
                new LinkedList<>(), R.drawable.event_5);

        events.add(penguinsFromMadagascar);
        events.add(sheepDolly);
        events.add(gorillaHarambe);
        events.add(underwaterExtravaganza);
        events.add(africanParty);
        events.add(asianMania);
    }

    public static void currentUserLikeEvent(int eventId){
        for(Event e : Event.events){
            if(e.id == eventId){
                List<Integer> userIds = e.getUserIdsLiked();
                int i = 0;
                boolean found = false;
                for(int id: userIds){
                    if(id == User.currentUser.getId()) {
                        userIds.remove(i);
                        found = true;
                        break;
                    }
                }
                if(found == false){
                    userIds.add(User.currentUser.getId());
                }
                break;
            }
        }
    }

    private int id;
    private String name;
    private String description;
    private List<Integer> userIdsLiked;
    private int imageResource;

    public Event(int id, String name, String description, List<Integer> userIdsLiked, int imageResource) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userIdsLiked = userIdsLiked;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getUserIdsLiked() {
        return userIdsLiked;
    }

    public void setUserIdsLiked(List<Integer> userIdsLiked) {
        this.userIdsLiked = userIdsLiked;
    }
}
