package algo;
import java.util.*;

// Largeur
public class AStar {

    protected Probleme problem;
    protected ProblemeEtat intial_state;
    protected ProblemeEtat end_node;
    /*
     * La liste des noeuds a étendre
     */
    protected Queue<ProblemeEtat> frontier = null;

    /*
     * La liste de noeuds déjà traités
     */
    protected HashSet<ProblemeEtat> explored = new HashSet<ProblemeEtat>();

    // Liste contenant tout les noeuds finaux, trié par score
    protected ArrayList<ProblemeEtat> final_nodes = new ArrayList<ProblemeEtat>();

    /**
     * Crée un algorithme de recherche
     *
     * @param p Le problème à résoudre
     * @param s L'état initial
     */
    public AStar(Probleme p, ProblemeEtat s) {
        this.problem = p;
        this.intial_state = s;
        //Initialisation de la frontier FIFO
        frontier = new PriorityQueue<>(new SearchNodeComparator());
    }

    public boolean solve() {
        System.out.println("Algo choisi: BFS");
        ProblemeEtat node = intial_state;

        // On commence à l'état initial
        frontier.add(node);

        // On initialise l'ensemble des nœuds déjà explorés a vide
        explored.clear();


        while (!frontier.isEmpty()) {
            // Retirer un noeud de la frontière selon une stratégie, stratégie: largeur
            node = frontier.poll();

            // Si le noeud contient un état but
            if (problem.estFinal(node)) {
                // On ajoute le noeuf dans la liste des noeuds finaux
                final_nodes.add(node);
                if(final_nodes.size() > 20){
                    // On retourne vrai
                    return true;
                }
            }else {
                // On ajoute l'état du noeud dans l'ensemble des noeuds explorés
                explored.add(node);
//                System.out.println(node);

                // Les actions possibles depuis cet état
                ArrayList<Action> actions = problem.getActions(node);

                // Affichage des actions
//                for (Action a : actions) {
//                    System.out.println(a);
//                }
//                System.out.println("");

                // Pour chaque nœud enfant
                for (Action a : actions) {
                    System.out.println(a);
                    // Nœud enfant
                    ProblemeEtat child = problem.executer(node, a);

                    // S'il n'est pas dans la frontière et si son état n'a pas été visité
                    if (!frontier.contains(child) && !explored.contains(child)) {
                        // L'insérer dans la frontière
                        frontier.add(child);
                    }else if(frontier.contains(child)){
                        // Si le nœud est déjà dans la frontière
                        // On récupère le nœud de la frontière
                        ProblemeEtat frontier_node = frontier.stream().filter(n -> n.equals(child)).findFirst().get();
                        // Si la somme heuristique + cout du nœud enfant est inférieur à celle du nœud de la frontière
                        if((child.getHeuristique() + child.getScore()) > (frontier_node.getHeuristique() + frontier_node.getScore())){
                            // On le remplace
                            frontier.remove(frontier_node);
                            frontier.add(child);
                        }
                    }
                }
            }

        }

        // Pas de solutions trouvées
        return false;
    }

    public ProblemeEtat getEnd_node(){
        Collections.sort(final_nodes, new Comparator<ProblemeEtat>() {
            @Override
            public int compare(ProblemeEtat o1, ProblemeEtat o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        return final_nodes.get(0);
    }

    private static class SearchNodeComparator implements Comparator<ProblemeEtat> {
        @Override
        public int compare(ProblemeEtat node1, ProblemeEtat node2) {
            return Double.compare((node2.getHeuristique() + node2.getScore()), (node1.getHeuristique() + node1.getScore()));
        }
    }

}
