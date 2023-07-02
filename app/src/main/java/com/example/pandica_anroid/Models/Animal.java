package com.example.pandica_anroid.Models;

import com.example.pandica_anroid.R;

import java.util.LinkedList;
import java.util.List;

public class Animal {

    public static List<Animal> animals;
    public static Animal currentAnimal = null;

    static {
        animals = new LinkedList<>();
        //TODO: prepraviti ovo
        Animal giraffePeter = new Animal(0,"Zirafa Petar", "Upoznajte Zirafu Petra - elegantno diva koja će oduševiti vaša srca. Uživajte u blizini ovog fascinantnog stvorenja, divite se njegovoj gracioznosti i izduženom vratu. Doživite nezaboravne trenutke posmatrajući Petra kako korača s ponosom. Posetite zoološki vrt i otkrijte čaroliju Zirafe Petra",
                new LinkedList<>(), R.drawable.animal_0);
        Comment c1 = new Comment(0,"Najvisa zirafa koju sam video");
        Comment c2 = new Comment(1, "Malo je agresivna, nemojte joj se priblizavati, ali veoma lepa.");
        giraffePeter.getComments().add(c1);
        giraffePeter.getComments().add(c2);

        Animal penguinRico = new Animal(1, "Pingvin Riko", "Otkrijte čarobni svet pingvina Rika! Upoznajte simpatičnog Rika i uživajte u nezaboravnom iskustvu. Doživite njegovu živopisnu igru i ples, upoznajte njegove prijatelje i osetite radost koju samo on može pružiti. Posetite pingvina Rika i zakoračite u svet čuda!",
                new LinkedList<>(),R.drawable.animal_1);

        Animal lionSimba = new Animal(1, "Lav Simba", "Doživite snagu i moć lava Simbe uživo! Osetite uzbuđenje dok gledate kako Simba vladara dominira svojim kraljevskim teritorijem. Njegova lepota i hrabrost oduzimaju dah. Posetite zoološki vrt i uđite u svet divljine dok se suočavate sa kraljem džungle - lavom Simbom!",
                new LinkedList<>(),R.drawable.animal_2);

        Animal bambi = new Animal(1, "Lane Bambi", "Upustite se u magični svet nežnosti i igre uz lane Bambi. Očarajte se njegovim nevinošću i lepotom dok trči kroz pašnjake. Osetite radost i toplinu dok se približavate ovom simbolu nevinosti. Posetite zoološki vrt i doživite nezaboravne trenutke s ljupkim lanetom Bambi.",
                new LinkedList<>(),R.drawable.animal_3);

        Animal sheepDolly = new Animal(1, "Ovca Doli", "Zavirite u čarobni svet vune i nežnosti s ovcicom Doli! Upoznajte ovu izuzetnu ovcu čije runo oduševljava svojom mekoćom. Uživajte u blizini Doli i osetite mir i spokoj koje samo ona može pružiti. Posetite zoološki vrt i dozvolite da vas obuzme čar ovce Doli!",
                new LinkedList<>(),R.drawable.animal_4);

        Animal gorillaHarambe = new Animal(1, "Gorila Harambe", "Zaronite u svet divlje snage s gorilom Harambom! Doživite bliski susret s ovim fascinantnim bićem, svedočite njegovoj inteligenciji i snažnom karakteru. Budite svedok jedinstvene veze između čoveka i divljine. Posetite zoološki vrt i doživite nezaboravnu avanturu s gorilom Harambom!",
                new LinkedList<>(),R.drawable.animal_5);

        Animal pandaPo = new Animal(1, "Panda Po", "Upoznajte šarmantnu pandu Po - simbol mekoće i ljupkosti! Oduševite se njegovom neodoljivom igrom i simpatičnim izrazom lica. Osetite mirnu energiju koju ova retka vrsta donosi. Posetite zoološki vrt i uronite u svet ljubavi i harmonije s pandom Po!",
                new LinkedList<>(),R.drawable.animal_6);

        Animal tigerJovan = new Animal(1, "Tigar Jovan", "Iskusite snagu i eleganciju tigra Jovana! Budite svedok njegove maestralne moći dok se kreće kroz svoj teritorij. Osetite uzbuđenje dok se suočavate s ovim vladarom džungle. Posetite zoološki vrt i doživite nezaboravnu avanturu s tigrom Jovanom - pravim kraljem divljine!",
                new LinkedList<>(),R.drawable.animal_7);

        Animal zebraSteva = new Animal(1, "Zebra Stev", "Upoznajte zebru Stevu! Ovaj šarmantni stanovnik Zoološkog vrta će očarati sve posetioce svojim crno-belim prugama i ljupkim pogledom. Provedite dan uživajući u šetnji kroz prirodno okruženje, upoznajte Stevu i otkrijte fascinantne činjenice o životu ovih predivnih životinja. Posetite nas i doživite nezaboravno iskustvo s ovim veselim zebrama!",
                new LinkedList<>(),R.drawable.animal_8);

        Animal dolphinTilicum = new Animal(1, "Delfin Tilikum", "Upoznajte delfina Tilikuma! U Zoološkom vrtu, Tilikum će vas očarati svojom gracioznošću i inteligencijom. Uživajte u fascinantnim predstavama, gledajući kako izvodi zadivljujuće trikove i pokazuje svoju neverovatnu vezu s trenerima. Posetite nas i doživite magiju morskog sveta s Tilikumom!",
                new LinkedList<>(),R.drawable.animal_9);

        animals.add(giraffePeter);
        animals.add(penguinRico);
        animals.add(lionSimba);
        animals.add(bambi);
        animals.add(sheepDolly);
        animals.add(gorillaHarambe);
        animals.add(pandaPo);
        animals.add(tigerJovan);
        animals.add(zebraSteva);
        animals.add(dolphinTilicum);

    }

    public Animal(){

    }

    public Animal(int id, String name, String description, List<Comment> comments, int imageResource) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comments = comments;
        this.imageResource = imageResource;
    }

    private int id;
    private String name;
    private String description;
    private List<Comment> comments;
    private int imageResource;

    public int getImage() {
        return imageResource;
    }

    public void setImage(int imageResource) {
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
