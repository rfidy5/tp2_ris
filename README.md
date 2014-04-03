tp2_ris
=======

1)
Le but de ce tp est de suivre un modèle objet, pour créer des classes et les rendre persistantes en utilisant les entités,puis créer des instances persistantes de ces classes/

voici un exemple de code:

@Entity
public class Person {


private Long id;
private String nom;
private String prenom;
private Boolean genre;
private String mail;
private Date dateNaissance;
private String profileFB;


@Id
@GeneratedValue
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
// pareil pour tous les autres attributs 

2) 
On étent un peu plus, la première question en créant des associations entre les entités.


voici un exemple de code:

private List<Home> home = new ArrayList<Home>();

	@OneToMany(mappedBy = "personne", cascade = CascadeType.PERSIST)
    public List<Home> getHome() {
return home;
}
public void setHome(List<Home> home) {
this.home = home;
}



3)
à la fin, on rajoute une classe de service qui nous permettra de peupler la base de données, et en meme temps l'intéroger en faisant des requetes


voici un exmeple de code d'une méthode pour créer des maisons, si il y' en a pas pour une personne x

	private void createHome(){

int numberHome = manager.createQuery("Select h From Home h", Home.class).getResultList().size();

        if (numberHome == 0) {

            Person person = new Person("Fidy");

            manager.persist(person);

            manager.persist(new Home("Saint Anne",person));

            manager.persist(new Home("Rennes",person));

        }



}


