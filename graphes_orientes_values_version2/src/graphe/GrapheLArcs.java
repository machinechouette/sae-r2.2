package graphe;

import java.util.ArrayList;
import java.util.List;

public class GrapheLArcs implements IGraphe {
    // Écrivez une classe GrapheLArcs qui représente un graphe à l’aide d’une liste d’une liste d’arcs.
    // Les nœuds N qui n’ont aucun arc entrant ni sortant seront représentés
    // par un arc factice de N vers un nœud dont le nom est la chaine vide « » et dont la valuation est 0.

    private List<Arc> arcs;

    public GrapheLArcs() {
        arcs = new ArrayList<>();
    }

    @Override
    public List<String> getSommets() {
        List<String> sommets = new ArrayList<>();

        for (Arc arc : arcs) {
            String source = arc.getSource();
            String destination = arc.getDestination();

            if (!sommets.contains(source)) {
                sommets.add(source);
            }

            if (!sommets.contains(destination)) {
                sommets.add(destination);
            }
        }

        return sommets;
    }

    @Override
    public List<String> getSucc(String sommet) {
        List<String> successeurs = new ArrayList<>();

        for (Arc arc : arcs) {
            String source = arc.getSource();
            String destination = arc.getDestination();

            if (source.equals(sommet)) {
                successeurs.add(destination);
            }
        }

        return successeurs;
    }

    @Override
    public int getValuation(String src, String dest) {
        for (Arc arc : arcs) {
            String source = arc.getSource();
            String destination = arc.getDestination();
            int valuation = arc.getValuation();

            if (source.equals(src) && destination.equals(dest)) {
                return valuation;
            }
        }

        return 0;
    }

    @Override
    public boolean contientSommet(String sommet) {
        for (Arc arc : arcs) {
            String source = arc.getSource();
            String destination = arc.getDestination();

            if (source.equals(sommet) || destination.equals(sommet)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contientArc(String src, String dest) {
        for (Arc arc : arcs) {
            String source = arc.getSource();
            String destination = arc.getDestination();

            if (source.equals(src) && destination.equals(dest)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void ajouterSommet(String noeud) {
        // Ne fais rien car la liste d'arcs est mise à jour dynamiquement lors de l'ajout d'arcs.
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        Arc arc = new Arc(source, destination, valeur);
        arcs.add(arc);
    }

    @Override
    public void oterSommet(String noeud) {
        List<Arc> arcsASupprimer = new ArrayList<>();

        for (Arc arc : arcs) {
            String source = arc.getSource();
            String destination = arc.getDestination();

            if (source.equals(noeud) || destination.equals(noeud)) {
                arcsASupprimer.add(arc);
            }
        }

        arcs.removeAll(arcsASupprimer);
    }

    @Override
    public void oterArc(String source, String destination) {
        Arc arcASupprimer = null;

        for (Arc arc : arcs) {
            String arcSource = arc.getSource();
            String arcDestination = arc.getDestination();

            if (arcSource.equals(source) && arcDestination.equals(destination)) {
                arcASupprimer = arc;
                break;
            }
        }

        if (arcASupprimer != null) {
            arcs.remove(arcASupprimer);
        }
    }

    @Override
    public void ajouterArc(String source, String destination, String destination2) {
        // Ne fais rien car la classe GrapheLArcs utilise une liste d'arcs, pas une liste de destinations multiples.
    }
    
    
}
