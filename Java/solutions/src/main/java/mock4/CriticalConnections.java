package mock4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer,List<Integer>> connectionMap=new HashMap<>();

        //Build connection count
        for(List<Integer> connection:connections){
            Integer fromNode = connection.get(0);
            Integer toNode = connection.get(1);
            List<Integer> currentConnections=connectionMap.get(fromNode);
            if(currentConnections == null) currentConnections=new ArrayList<Integer>();
            currentConnections.add(toNode);
            connectionMap.put(fromNode,currentConnections);

            currentConnections=connectionMap.get(toNode);
            if(currentConnections == null) currentConnections=new ArrayList<Integer>();
            currentConnections.add(fromNode);
            connectionMap.put(toNode,currentConnections);
        }

        List<List<Integer>> result=new ArrayList<>();
        for(Integer fromNode:connectionMap.keySet()){
            List<Integer> currentConnections=connectionMap.get(fromNode);
            if(currentConnections!=null && currentConnections.size() == 1){
                List<Integer> criticalConnection=new ArrayList<>();
                criticalConnection.add(fromNode);
                criticalConnection.add(currentConnections.get(0));
                result.add(criticalConnection);
            }
        }
        return result;
    }
}
