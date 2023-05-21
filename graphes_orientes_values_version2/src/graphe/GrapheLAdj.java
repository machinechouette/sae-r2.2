package graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheLAdj implements IGraphe {
	// Écrivez une classe GrapheLAdj qui représente un graphe par des listes d’adjacence

	private Map<String, List<Arc>> ladj;

	public GrapheLAdj() {
		ladj = new HashMap<>();
	}

	@Override
	public List<String> getSommets() {
		return new ArrayList<>(ladj.keySet());
	}

	@Override
	public List<String> getSucc(String sommet) {
		if (ladj.containsKey(sommet)) {
			List<Arc> arcs = ladj.get(sommet);
			List<String> successeurs = new ArrayList<>();
			for (Arc arc : arcs) {
				successeurs.add(arc.getDestination());
			}
			return successeurs;
		}
		return new ArrayList<>();
	}

	@Override
	public int getValuation(String src, String dest) {
		if (ladj.containsKey(src)) {
			List<Arc> arcs = ladj.get(src);
			for (Arc arc : arcs) {
				if (arc.getDestination().equals(dest)) {
					return arc.getValuation();
				}
			}
		}
		return 0;
	}

	@Override
	public boolean contientSommet(String sommet) {
		return ladj.containsKey(sommet);
	}

	@Override
	public boolean contientArc(String src, String dest) {
		if (ladj.containsKey(src)) {
			List<Arc> arcs = ladj.get(src);
			for (Arc arc : arcs) {
				if (arc.getDestination().equals(dest)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void ajouterSommet(String noeud) {
		if (!ladj.containsKey(noeud)) {
			ladj.put(noeud, new ArrayList<>());
		}
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		Arc arc = new Arc(source, destination, valeur);
		if (ladj.containsKey(source)) {
			List<Arc> arcs = ladj.get(source);
			arcs.add(arc);
		} else {
			List<Arc> arcs = new ArrayList<>();
			arcs.add(arc);
			ladj.put(source, arcs);
		}
	}

	@Override
	public void oterSommet(String noeud) {
		if (ladj.containsKey(noeud)) {
			ladj.remove(noeud);
			// Supprimer les arcs entrants
			for (String sommet : ladj.keySet()) {
				List<Arc> arcs = ladj.get(sommet);
				arcs.removeIf(arc -> arc.getDestination().equals(noeud));
			}
		}
	}

	@Override
	public void oterArc(String source, String destination) {
		if (ladj.containsKey(source)) {
			List<Arc> arcs = ladj.get(source);
			arcs.removeIf(arc -> arc.getDestination().equals(destination));
		}
	}

	@Override
	public void ajouterArc(String source, String destination, String destination2) {
		// Cette méthode n'est pas applicable pour la classe GrapheLAdj
		throw new UnsupportedOperationException("Méthode non applicable pour la classe GrapheLAdj");
	}
	
	@Override
    public String toString() {
        List<String> descriptionsArcs = new ArrayList<>();

        for (String sommet : ladj.keySet()) {
            List<Arc> arcs = ladj.get(sommet);
            for (Arc arc : arcs) {
                descriptionsArcs.add(sommet + "-" + arc.getDestination() + "(" + arc.getValuation() + ")");
            }
        }

        return String.join(", ", descriptionsArcs);
    }
}
