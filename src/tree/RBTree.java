import java.util.Objects;

/**
 * @author: alangong
 * @create: 2020-08-24 20:14
 * @description:
 **/
public class RBTree<K extends Comparable<K>, V> {
    //哨兵节点
    private final Node<K, V> NIL = new Node<>(null, null, Constant.Black, null, null, null);

    private Node<K, V> root = NIL;

    static class Node<K, V> {
        private K key;
        private V value;
        private int color;
        private Node<K, V> left;
        private Node<K, V> right;
        private Node<K, V> p;

        public Node(K key, V value, int color, Node<K, V> left, Node<K, V> right, Node<K, V> p) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.left = left;
            this.right = right;
            this.p = p;
        }
    }

    public V get(K key) {
        if (root == NIL) {
            return null;
        }
        return Objects.requireNonNull(search(root, key)).value;
    }

    private Node<K, V> search(Node<K, V> node, K key) {
        if (node == NIL) return null;
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public void put(K key, V value) {
        Node<K, V> y = NIL;
        Node<K, V> x = root;
        while(x != NIL) {
            y = x;
            if(key.compareTo(x.key) == 0) {
                x.value = value;
                return;
            } else if (key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        // 树为空
        if (y == NIL) {
            root = new Node<>(key, value, Constant.Black, NIL, NIL, NIL);
            return;
        }
        Node<K, V> z = new Node<>(key, value, Constant.Red, NIL, NIL, y);
        if (key.compareTo(y.key) < 0) {
            y.left = z;
        } else {
            y.right = z;
        }
        putFixUp(z);
    }

    private void putFixUp(Node<K, V> z) {
        while(z.p.color == Constant.Red) {
            if (z.p == z.p.p.left) {
                Node<K, V> x = z.p.p.right;
                // case 1
                if (x.color == Constant.Red) {
                    z.p.color = Constant.Black;
                    x.color = Constant.Black;
                    z.p.p.color = Constant.Red;
                    z = z.p.p;
                } else {
                    // case 2
                    if (z == z.p.right) {
                        z = z.p;
                        leftRotate(z);
                    }
                    // case 3
                    z.p.color = Constant.Black;
                    z.p.p.color = Constant.Red;
                    rightRotate(z.p.p);
                }
            } else {
                Node<K, V> x = z.p.p.left;
                // case 1
                if (x.color == Constant.Red) {
                    z.p.color = Constant.Black;
                    x.color = Constant.Black;
                    z.p.p.color = Constant.Red;
                    z = z.p.p;
                } else {
                    // case 2
                    if (z == z.p.left) {
                        z = z.p;
                        rightRotate(z);
                    }
                    // case 3
                    z.p.color = Constant.Black;
                    z.p.p.color = Constant.Red;
                    leftRotate(z.p.p);
                }
            }
            root.color = Constant.Black;
        }
    }

    public void remove(K key) {
        Node<K, V> x = search(root, key);
        if (x == NIL) return;
        delete(x);
    }

    private void delete(Node<K, V> x) {
        Node<K, V> y = x, z;
        int yOriginalColor = x.color;
        if (x.left == NIL) {
            z = x.right;
            transPlant(x, x.right);
        } else if (x.right == NIL) {
            z = x.left;
            transPlant(x, x.left);
        } else {
            y = miniMum(x.right);
            yOriginalColor = y.color;
            z = y.right;
            if (y.p != x) {
                transPlant(y, y.right);
                y.right = x.right;
                y.right.p = y;
            }
            transPlant(x, y);
            y.left = x.left;
            y.left.p = y;
            y.color = x.color;
        }
        if (yOriginalColor == Constant.Black) {
            deleteFixUp(z);
        }
    }

    private void deleteFixUp(Node<K, V> x) {

    }

    private void leftRotate(Node<K, V> x) {
        Node<K, V> y = x.right;
        x.right = y.left;
        if (y.left != NIL) {
            y.left.p = x;
        }
        y.p = x.p;
        if (x.p == NIL) {
            root = y;
        } else if (x == x.p.left) {
            x.p.left = y;
        } else {
            x.p.right = y;
        }
        y.left = x;
        x.p = y;
    }

    private void rightRotate(Node<K, V> x) {
        Node<K, V> y = x.left;
        x.left = y.right;
        if (y.right != NIL) {
            y.right.p = x;
        }
        y.p = x.p;
        if (x.p == NIL) {
            root = y;
        } else if (x == x.p.right) {
            x.p.right = y;
        } else {
            x.p.left = y;
        }
        y.right = x;
        x.p = y;
    }

    // 用y为根的子树替换x
    private void transPlant(Node<K, V> x, Node<K, V> y) {
        if (x.p == NIL) {
            root = y;
        } else if (x == x.p.left) {
            y = x.p.left;
        } else {
            y = x.p.right;
        }
        y.p = x.p;
    }

    private Node<K, V> miniMum(Node<K, V> p) {
        while (p.left != NIL) {
            p = p.left;
        }
        return p;
    }
}
