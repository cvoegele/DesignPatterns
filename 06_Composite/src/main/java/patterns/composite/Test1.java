package patterns.composite;

public class Test1 {

	/*
		Figure f1 is only allowed to be in one Group, however here it is on both.
		What would happen if we moved one group. The second group would move apart,
		because f1 is in both groups.

		FIX:
		1. Add parameter to figure class boolean. IF it is contained, set it to true.
		So if it is being added but it is already on true throw exception

		2. Global List of all components that are already part of a group.
	 */

    public static void main(String[] args) {
        Figure f1 = new RectangleFigure("f1");
        Figure f2 = new RectangleFigure("f2");
        Figure f3 = new OvalFigure("f3");
        GroupFigure g1 = new GroupFigure("g1", f1, f2);

        GroupFigure g2 = new GroupFigure("g2", f3, f1);
        g1.draw("");
        g2.draw("");
    }
}
