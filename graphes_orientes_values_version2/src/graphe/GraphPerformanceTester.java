package graphe;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphPerformanceTester {
    private static final int NUM_TESTS = 10; // Nombre de tests à effectuer pour chaque graphe

    public static void main(String[] args) {
        // Générer les graphes de différentes tailles et structures
        IGraphe grapheLArcs = generateGrapheLArcs();
        IGraphe grapheMAdj = generateGrapheMAdj();
        IGraphe grapheLAdj = generateGrapheLAdj();
        IGraphe grapheHHAdj = generateGrapheHHAdj();

        // Mesurer le temps d'exécution de Dijkstra pour chaque graphe
        long timeLArcs = measureDijkstraTime(grapheLArcs);
        long timeMAdj = measureDijkstraTime(grapheMAdj);
        long timeLAdj = measureDijkstraTime(grapheLAdj);
        long timeHHAdj = measureDijkstraTime(grapheHHAdj);

        // Afficher les résultats
        System.out.println("Temps d'exécution de Dijkstra (GrapheLArcs): " + timeLArcs + " ms");
        System.out.println("Temps d'exécution de Dijkstra (GrapheMAdj): " + timeMAdj + " ms");
        System.out.println("Temps d'exécution de Dijkstra (GrapheLAdj): " + timeLAdj + " ms");
        System.out.println("Temps d'exécution de Dijkstra (GrapheHHAdj): " + timeHHAdj + " ms");
    }

    private static IGraphe generateGrapheLArcs() {
        //private static IGraphe generateGrapheLArcs() {
    GrapheLArcs grapheLArcs = new GrapheLArcs();

	    // Ajouter des sommets et des arcs au graphe
	    grapheLArcs.ajouterSommet("A");
	    grapheLArcs.ajouterSommet("B");
	    grapheLArcs.ajouterSommet("C");
	
	    grapheLArcs.ajouterArc("A", "B", 5);
	    grapheLArcs.ajouterArc("A", "C", 8);
	    grapheLArcs.ajouterArc("B", "C", 3);
	
	    return grapheLArcs;
	}
 

    private static IGraphe generateGrapheMAdj() {
        //private static IGraphe generateGrapheMAdj() {
    GrapheMAdj grapheMAdj = new GrapheMAdj();

    // Initialiser la matrice d'adjacence avec les valeurs appropriées
    int[][] matrice = {
        { 0, 5, 8 },
        { 0, 0, 3 },
        { 0, 0, 0 }
    };

    grapheMAdj.setMatrice(matrice);

    return grapheMAdj;
//}
    }

    private static IGraphe generateGrapheLAdj() {
        //private static IGraphe generateGrapheLAdj() {
    GrapheLAdj grapheLAdj = new GrapheLAdj();

    // Ajouter des listes d'adjacence pour chaque sommet avec les arcs correspondants
    grapheLAdj.ajouterSommet("A");
    grapheLAdj.ajouterSommet("B");
    grapheLAdj.ajouterSommet("C");

    grapheLAdj.ajouterArc("A", "B", 5);
    grapheLAdj.ajouterArc("A", "C", 8);
    grapheLAdj.ajouterArc("B", "C", 3);

    return grapheLAdj;
//}
    }

    private static IGraphe generateGrapheHHAdj() {
        //private static IGraphe generateGrapheHHAdj() {
    GrapheHHAdj grapheHHAdj = new GrapheHHAdj();

    // Initialiser les tables de hachage imbriquées avec les valeurs appropriées
    Map<String, Map<String, Integer>> hhadj = new HashMap<>();

    Map<String, Integer> succA = new HashMap<>();
    succA.put("B", 5);
    succA.put("C", 8);
    hhadj.put("A", succA);

    Map<String, Integer> succB = new HashMap<>();
    succB.put("C", 3);
    hhadj.put("B", succB);

    grapheHHAdj.setHHAdj(hhadj);

    return grapheHHAdj;
//}
    }

    private static long measureDijkstraTime(IGraphe graphe) {
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            // Début du chronomètre
            long startTime = System.currentTimeMillis();

         // Exécution de l'algorithme de Dijkstra sur le graphe
            long startTime1 = System.nanoTime();
            List<String> sommets = graphe.getSommets();

            for (String sommet : sommets) {
                List<String> cheminPlusCourt = dijkstra(graphe, sommet);
                System.out.println("Chemin le plus court à partir du sommet " + sommet + ": " + cheminPlusCourt);
            }

            long endTime = System.nanoTime();
            long executionTime = endTime - startTime1;
            System.out.println("Temps d'exécution de l'algorithme de Dijkstra: " + executionTime + " nanosecondes");

            // Fin du chronomètre
            long endTime1 = System.currentTimeMillis();

            // Ajouter le temps d'exécution au total
            totalTime += (endTime1 - startTime1);
        }

        // Calculer le temps moyen d'exécution
        long averageTime = totalTime / NUM_TESTS;

        return averageTime;
    }

	private static List<String> dijkstra(IGraphe graphe, String sommet) {
		// TODO Auto-generated method stub
		return null;
	}
}