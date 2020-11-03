package patterns.composite;

import java.util.LinkedList;
import java.util.List;

public class GroupFigure extends Figure {
    private String name;
    private List<Figure> figures = new LinkedList<>();

    public GroupFigure(String name, Figure... figures) {
        this.name = name;
        for (Figure f : figures) {
            if (f.contained) throw new IllegalArgumentException("Figure is already part of a figure");

            addFigure(f);
            f.contained = true;
        }
    }

    public boolean contains(Figure f) {
        if (f == this) return true;

        if (figures.contains(f)) return true;

        //recursively check in each subgroup if f is part of any of these
        for (var fig : figures) {
            if (fig instanceof GroupFigure) {
                if (((GroupFigure) fig).contains(f)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void addFigure(Figure f) {

        /*
         if we add a figure, we have to check if this is part of that group,
         which would create a cycle if added.
         This violates the tree structure.
         */
        if (f instanceof GroupFigure) {
            if (((GroupFigure) f).contains(this))
                throw new IllegalArgumentException("this group is already a child of the to be added group or the same group");
        }

        figures.add(f);
    }

    @Override
    public void draw(String prefix) {
        System.out.println(prefix + name);
        for (Figure f : figures) {
            f.draw(prefix + ">>");
        }
    }
}
