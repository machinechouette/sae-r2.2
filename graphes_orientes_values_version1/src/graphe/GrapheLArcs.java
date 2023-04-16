package graphe;

import java.util.List;

public class GrapheLArcs implements IGraphe {
	//Écrivez une classe GrapheLArcs qui représente un graphe à l’aide d’une liste d’une liste d’arcs. 
	//Les nœuds N qui n’ont aucun arc entrant ni sortant seront représentés 
	//par un arc factice de N vers un nœud dont le nom est la chaine vide « » et dont la valuation est 0.
	
	private List<Arc> arcs ;

	public GrapheLArcs() {
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
