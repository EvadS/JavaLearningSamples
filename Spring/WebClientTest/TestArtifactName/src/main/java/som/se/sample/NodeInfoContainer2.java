package som.se.sample;

import java.util.List;

public class NodeInfoContainer2 {
    List<NodeInfoContainer> nodeInfoContainer;

    public NodeInfoContainer2(List<NodeInfoContainer> nodeInfoContainer) {
        this.nodeInfoContainer = nodeInfoContainer;
    }

    public NodeInfoContainer2() {
    }

    public List<NodeInfoContainer> getNodeInfoContainer() {
        return nodeInfoContainer;
    }

    public void setNodeInfoContainer(List<NodeInfoContainer> nodeInfoContainer) {
        this.nodeInfoContainer = nodeInfoContainer;
    }
}
