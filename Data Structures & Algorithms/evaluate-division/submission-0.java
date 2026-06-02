class Solution {

    Map<String, String> parent;
    Map<String, Double> weight;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parent = new HashMap<>();
        weight = new HashMap<>();

        for(int i=0;i<equations.size();i++){
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            union(x, y, values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String x = queries.get(i).get(0), y = queries.get(i).get(1);
            if(!parent.containsKey(x) || !parent.containsKey(y)) res[i] = -1.0;

            else if(find(x).equals(find(y))) res[i] = weight.get(x)/weight.get(y);
            else res[i] = -1.0;
        }

        return res;
    }

    private String find(String x){
        if(!parent.containsKey(x)){
            parent.put(x, x);
            weight.put(x, 1.0);
        }

        if(!parent.get(x).equals(x)){
            String root = find(parent.get(x));
            weight.put(x, weight.get(x)*weight.get(parent.get(x)));
            parent.put(x, root);
        }

        return parent.get(x);
    }

    private void union(String x, String y, double val){
        String rx = find(x), ry = find(y);
        if(rx.equals(ry)) return;

        weight.put(rx, val*weight.get(y)/weight.get(x));
        parent.put(rx, ry);
    }
}