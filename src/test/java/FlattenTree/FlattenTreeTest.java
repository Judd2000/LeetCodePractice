package FlattenTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlattenTreeTest {

    FlattenTree test;

    @BeforeEach
    void setup() {
        test = new FlattenTree();
    }

    @Test
    void testFlatten() {
        TreeNode testNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(5, null, new TreeNode(6)));
        TreeNode solution = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6))))));
        test.flatten(testNode);
        assertTrue(solution.equals(testNode));
    }

    @Test
    void testTreeNodeEquals() {
        TreeNode testNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        TreeNode compareNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        assertTrue(testNode.equals(compareNode));
    }
}
