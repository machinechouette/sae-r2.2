package graphe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheMAdj implements IGraphe {
    // Écrivez une classe GrapheMAdj qui représente un graphe à l’aide d’une matrice d’adjacence.

    private int[][] matrice;
    private Map<String, Integer> indices;

    public GrapheMAdj() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<String> getSommets() {
        List<String> sommets = new ArrayList<>(indices.keySet());
        return sommets;
    }

    @Override
    public List<String> getSucc(String sommet) {
        List<String> successeurs = new ArrayList<>();
        int sommetIndex = indices.getOrDefault(sommet, -1);

        if (sommetIndex != -1) {
            for (int i = 0; i < matrice[sommetIndex].length; i++) {
                if (matrice[sommetIndex][i] > 0) {
                    String successeur = getKeyByValue(indices, i);
                    successeurs.add(successeur);
                }
            }
        }

        return successeurs;
    }

    @Override
    public int getValuation(String src, String dest) {
        int srcIndex = indices.getOrDefault(src, -1);
        int destIndex = indices.getOrDefault(dest, -1);

        if (srcIndex != -1 && destIndex != -1) {
            return matrice[srcIndex][destIndex];
        }

        return 0;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return indices.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        int srcIndex = indices.getOrDefault(src, -1);
        int destIndex = indices.getOrDefault(dest, -1);

        if (srcIndex != -1 && destIndex != -1) {
            return matrice[srcIndex][destIndex] > 0;
        }

        return false;
    }

    @Override
    public void ajouterSommet(String noeud) {
        if (!indices.containsKey(noeud)) {
            int newIndex = indices.size();
            indices.put(noeud, newIndex);

            // Redimensionner la matrice d'adjacence
            int[][] newMatrice = new int[newIndex + 1][newIndex + 1];
            for (int i = 0; i < matrice.length; i++) {
                System.arraycopy(matrice[i], 0, newMatrice[i], 0, matrice[i].length);
            }
            matrice = newMatrice;
        }
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        int srcIndex = indices.getOrDefault(source, -1);
        int destIndex = indices.getOrDefault(destination, -1);

        if (srcIndex != -1 && destIndex != -1) {
            matrice[srcIndex][destIndex] = valeur;
        }
    }

    @Override
    public void oterSommet(String noeud) {
        int indexToRemove = indices.getOrDefault(noeud, -1);

        if (indexToRemove != -1) {
            indices.remove(noeud);

            // Mettre à jour les indices
            Map<String, Integer> newIndices = new HashMap<>();
            int index = 0;
            for (String sommet : indices.keySet()) {
                newIndices.put(sommet, index);
            index++;
        }
        indices = newIndices;

        // Mettre à jour la matrice d'adjacence
        int[][] newMatrice = new int[indices.size()][indices.size()];
        int row = 0;
        int col = 0;
        for (int i = 0; i < matrice.length; i++) {
            if (i != indexToRemove) {
                col = 0;
                for (int j = 0; j < matrice[i].length; j++) {
                    if (j != indexToRemove) {
                        newMatrice[row][col] = matrice[i][j];
                        col++;
                    }
                }
                row++;
            }
        }
        matrice = newMatrice;
    }
}

@Override
public void oterArc(String source, String destination) {
    int srcIndex = indices.getOrDefault(source, -1);
    int destIndex = indices.getOrDefault(destination, -1);

    if (srcIndex != -1 && destIndex != -1) {
        matrice[srcIndex][destIndex] = 0;
    }
}

@Override
public void ajouterArc(String source, String destination, String destination2) {
    // Cette méthode n'est pas applicable à la représentation par matrice d'adjacence
    throw new UnsupportedOperationException("Méthode non applicable pour GrapheMAdj");
}

// Méthode utilitaire pour récupérer la clé correspondant à une valeur dans une map
private static <K, V> K getKeyByValue(Map<K, V> map, V value) {
    for (Map.Entry<K, V> entry : map.entrySet()) {
        if (entry.getValue().equals(value)) {
            return entry.getKey();
        }
    }
    return null;
}

public void setMatrice(int[][] matrice2) {
	// TODO Auto-generated method stub
	
}


}