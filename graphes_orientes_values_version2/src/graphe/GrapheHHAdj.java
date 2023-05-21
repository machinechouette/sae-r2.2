package graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheHHAdj implements IGraphe {
    //Écrivez une classe GrapheHHAdj qui représente un graphe
    //un peu comme le fait GrapheLAdj mais avec des tables de Hachage imbriquées au lieu de listes d’adjacennce.

    private Map<String, Map<String, Integer>> hhadj;

    public GrapheHHAdj() {
        hhadj = new HashMap<>();
    }

    @Override
    public List<String> getSommets() {
        return new ArrayList<>(hhadj.keySet());
    }

    @Override
    public List<String> getSucc(String sommet) {
        if (hhadj.containsKey(sommet)) {
            Map<String, Integer> successeurs = hhadj.get(sommet);
            return new ArrayList<>(successeurs.keySet());
        }
        return new ArrayList<>();
    }

    @Override
    public int getValuation(String src, String dest) {
        if (hhadj.containsKey(src)) {
            Map<String, Integer> successeurs = hhadj.get(src);
            if (successeurs.containsKey(dest)) {
                return successeurs.get(dest);
            }
        }
        return 0;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return hhadj.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        if (hhadj.containsKey(src)) {
            Map<String, Integer> successeurs = hhadj.get(src);
            return successeurs.containsKey(dest);
        }
        return false;
    }

    @Override
    public void ajouterSommet(String noeud) {
        if (!hhadj.containsKey(noeud)) {
            hhadj.put(noeud, new HashMap<>());
        }
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if (hhadj.containsKey(source)) {
            Map<String, Integer> successeurs = hhadj.get(source);
            successeurs.put(destination, valeur);
        } else {
            Map<String, Integer> successeurs = new HashMap<>();
            successeurs.put(destination, valeur);
            hhadj.put(source, successeurs);
        }
    }

    @Override
    public void oterSommet(String noeud) {
        if (hhadj.containsKey(noeud)) {
            hhadj.remove(noeud);
            for (Map<String, Integer> successeurs : hhadj.values()) {
                successeurs.remove(noeud);
            }
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        if (hhadj.containsKey(source)) {
            Map<String, Integer> successeurs = hhadj.get(source);
            successeurs.remove(destination);
        }
    }

    @Override
    public void ajouterArc(String source, String destination, String destination2) {
        if (hhadj.containsKey(source)) {
            Map<String, Integer> successeurs = hhadj.get(source);
            int valuation = getValuation(source, destination);
            successeurs.put(destination2, valuation);
        }
    }

	public void setHHAdj(Map<String, Map<String, Integer>> hhadj2) {
		// TODO Auto-generated method stub
		
	}
}
