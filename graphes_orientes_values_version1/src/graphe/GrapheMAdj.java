package graphe;

import java.util.List;
import java.util.Map;

public class GrapheMAdj implements IGraphe {
	//Écrivez une classe GrapheMAdj qui représente un graphe à l’aide d’une matrice d’adjacence.
	
	private int[][] matrice ;
	private Map<String, Integer> indices;

	public GrapheMAdj() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> getSommets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSucc(String sommet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getValuation(String src, String dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contientSommet(String sommet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contientArc(String src, String dest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ajouterSommet(String noeud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void oterSommet(String noeud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void oterArc(String source, String destination) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterArc(String source, String destination, String destination2) {
		// TODO Auto-generated method stub
		
	}

}
