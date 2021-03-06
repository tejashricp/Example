package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {



    static class Graph{
        int verticesLength;
        AdjNode[] adjList;

        public Graph(int verticesLength){
            this.verticesLength = verticesLength;
            this.adjList = new AdjNode[verticesLength];
            initiateAdjList(verticesLength);
        }

        private void initiateAdjList(int verticesLength) {
            for(int i=0;i<verticesLength;i++){
             adjList[i] = new AdjNode(i+1);
            }
        }

        public void addEdge(int src,int dest){
            adjList[src-1].pushBack(adjList[dest-1]);
            adjList[dest-1].pushBack(adjList[src-1]);
        }
    }

    static class AdjNode{
        int vertexNumber;
        List<AdjNode> adjNodelist;

        public AdjNode(int vertexNumber){
            this.vertexNumber = vertexNumber;
            adjNodelist = new ArrayList<>();
        }

        public void pushBack(AdjNode next) {
            adjNodelist.add(next);
        }
    }

    public static void main(String[] args){
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);

        graph.addEdge(2,3);
        graph.addEdge(2,5);

        graph.addEdge(3,6);

        graph.addEdge(4,5);
        graph.addEdge(4,6);

        graph.addEdge(5,6);

        doBFS(graph);
    }

    private static void doBFS(Graph graph) {
        Queue<AdjNode> queue = new LinkedList();
        int[] color = new int[graph.verticesLength];
        int[] level = new int[graph.verticesLength];
        queue.add(graph.adjList[0]);
        int levelNumber = 0;
        while(!queue.isEmpty()){
            AdjNode adjNode = queue.peek();
            color[adjNode.vertexNumber-1] = 1;
            levelNumber = level[adjNode.vertexNumber-1];
            for (AdjNode oneNode : adjNode.adjNodelist) {
                if(color[oneNode.vertexNumber-1] == 0) {
                    queue.add(oneNode);
                    color[oneNode.vertexNumber-1] = 1;
                    level[oneNode.vertexNumber-1] = levelNumber+1;
                }
            }
            System.out.print(adjNode.vertexNumber+" "+"("+level[adjNode.vertexNumber-1]+")"+" ");
            color[adjNode.vertexNumber-1] = 2;
            queue.poll();
        }
   }
}
