package mediateca_v01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Mediateca {

    private List<Material> materiales = new ArrayList<>();
    private int libroCount = 1;
    private int revistaCount = 1;
    private int cdCount = 1;
    private int dvdCount = 1;

    public static void main(String[] args) {
        Mediateca mediateca = new Mediateca();
        mediateca.iniciar();
    }

    public void iniciar() {
        JFrame frame = new JFrame("Gestión de Mediateca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton agregarBtn = new JButton("Agregar Material");
        JButton modificarBtn = new JButton("Modificar Material");
        JButton listarBtn = new JButton("Listar Materiales");
        JButton borrarBtn = new JButton("Borrar Material");
        JButton buscarBtn = new JButton("Buscar Material");
        JButton salirBtn = new JButton("Salir");

        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarMaterial();
            }
        });

        modificarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificarMaterial();
            }
        });

        listarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarMateriales();
            }
        });

        borrarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarMaterial();
            }
        });

        buscarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarMaterial();
            }
        });

        salirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel.add(agregarBtn);
        panel.add(modificarBtn);
        panel.add(listarBtn);
        panel.add(borrarBtn);
        panel.add(buscarBtn);
        panel.add(salirBtn);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void agregarMaterial() {
        String[] opciones = {"Libro", "Revista", "CD", "DVD"};
        String tipoMaterial = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de material a agregar:",
                "Agregar Material", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (tipoMaterial != null) {
            switch (tipoMaterial) {
                case "Libro":
                    agregarLibro();
                    break;
                case "Revista":
                    agregarRevista();
                    break;
                case "CD":
                    agregarCD();
                    break;
                case "DVD":
                    agregarDVD();
                    break;
            }
        }
    }

    private void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Título del Libro:");
        String autor = JOptionPane.showInputDialog("Autor:");
        String paginasStr = JOptionPane.showInputDialog("Número de páginas:");
        String editorial = JOptionPane.showInputDialog("Editorial:");
        String isbn = JOptionPane.showInputDialog("ISBN:");
        String anioStr = JOptionPane.showInputDialog("Año de publicación:");
        String unidadesStr = JOptionPane.showInputDialog("Unidades disponibles:");

        if (titulo != null && autor != null && paginasStr != null && editorial != null && isbn != null
                && anioStr != null && unidadesStr != null) {
            try {
                int paginas = Integer.parseInt(paginasStr);
                int anio = Integer.parseInt(anioStr);
                int unidades = Integer.parseInt(unidadesStr);
                String id = "LIB" + String.format("%05d", libroCount++);
                Libro libro = new Libro(id, titulo, autor, paginas, editorial, isbn, anio, unidades);
                materiales.add(libro);
                JOptionPane.showMessageDialog(null, "Libro agregado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en la entrada de datos.");
            }
        }
    }

    private void agregarRevista() {
        String titulo = JOptionPane.showInputDialog("Título de la Revista:");
        String editorial = JOptionPane.showInputDialog("Editorial:");
        String periodicidad = JOptionPane.showInputDialog("Periodicidad:");
        String fechaPublicacion = JOptionPane.showInputDialog("Fecha de publicación (YYYY-MM-DD):");
        String unidadesStr = JOptionPane.showInputDialog("Unidades disponibles:");

        if (titulo != null && editorial != null && periodicidad != null && fechaPublicacion != null && unidadesStr != null) {
            try {
                int unidades = Integer.parseInt(unidadesStr);
                String id = "REV" + String.format("%05d", revistaCount++);
                Revista revista = new Revista(id, titulo, editorial, periodicidad, fechaPublicacion, unidades);
                materiales.add(revista);
                JOptionPane.showMessageDialog(null, "Revista agregada exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en la entrada de datos.");
            }
        }
    }

    private void agregarCD() {
        String titulo = JOptionPane.showInputDialog("Título del CD:");
        String artista = JOptionPane.showInputDialog("Artista:");
        String genero = JOptionPane.showInputDialog("Género:");
        String duracionStr = JOptionPane.showInputDialog("Duración (en minutos):");
        String numCancionesStr = JOptionPane.showInputDialog("Número de canciones:");
        String unidadesStr = JOptionPane.showInputDialog("Unidades disponibles:");

        if (titulo != null && artista != null && genero != null && duracionStr != null && numCancionesStr != null && unidadesStr != null) {
            try {
                int duracion = Integer.parseInt(duracionStr);
                int numCanciones = Integer.parseInt(numCancionesStr);
                int unidades = Integer.parseInt(unidadesStr);
                String id = "CDA" + String.format("%05d", cdCount++);
                CD cd = new CD(id, titulo, artista, genero, duracion, numCanciones, unidades);
                materiales.add(cd);
                JOptionPane.showMessageDialog(null, "CD agregado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en la entrada de datos.");
            }
        }
    }

    private void agregarDVD() {
        String titulo = JOptionPane.showInputDialog("Título del DVD:");
        String director = JOptionPane.showInputDialog("Director:");
        String genero = JOptionPane.showInputDialog("Género:");
        String duracionStr = JOptionPane.showInputDialog("Duración (en minutos):");

        if (titulo != null && director != null && genero != null && duracionStr != null) {
            try {
                int duracion = Integer.parseInt(duracionStr);
                String id = "DVD" + String.format("%05d", dvdCount++);
                DVD dvd = new DVD(id, titulo, director, duracion, genero);
                materiales.add(dvd);
                JOptionPane.showMessageDialog(null, "DVD agregado exitosamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en la entrada de datos.");
            }
        }
    }

    private void modificarMaterial() {
        String id = JOptionPane.showInputDialog("Ingrese el código del material a modificar:");
        Material material = buscarPorId(id);
        
        if (material != null) {
            String nuevoTitulo = JOptionPane.showInputDialog("Nuevo título:", material.getTitulo());
            material.setTitle(nuevoTitulo);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Confirmar los cambios?");
            if (opcion == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Material modificado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Material no encontrado.");
        }
    }

    private void listarMateriales() {
        String[] columnas = {"ID", "Título", "Detalles"};
        String[][] data = new String[materiales.size()][3];

        for (int i = 0; i < materiales.size(); i++) {
            Material material = materiales.get(i);
            data[i][0] = material.getId();
            data[i][1] = material.getTitulo();
            data[i][2] = material.getDetalles();
        }

        JTable table = new JTable(data, columnas);
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Materiales Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    private void borrarMaterial() {
        String id = JOptionPane.showInputDialog("Ingrese el código del material a borrar:");
        Material material = buscarPorId(id);

        if (material != null) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea borrar el material?");
            if (opcion == JOptionPane.YES_OPTION) {
                materiales.remove(material);
                JOptionPane.showMessageDialog(null, "Material borrado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Material no encontrado.");
        }
    }

    private void buscarMaterial() {
        String[] criterios = {"Autor", "Título", "Género"};
        String criterio = (String) JOptionPane.showInputDialog(null, "Buscar material por:",
                "Buscar Material", JOptionPane.QUESTION_MESSAGE, null, criterios, criterios[0]);
        
        if (criterio != null) {
            String parametro = JOptionPane.showInputDialog("Ingrese el " + criterio + " a buscar:");
            List<Material> resultados = new ArrayList<>();

            for (Material material : materiales) {
                if ((criterio.equals("Autor") && material instanceof Libro && ((Libro) material).getAutor().equalsIgnoreCase(parametro)) ||
                    (criterio.equals("Título") && material.getTitulo().equalsIgnoreCase(parametro)) ||
                    (criterio.equals("Género") && material instanceof CD && ((CD) material).getGenero().equalsIgnoreCase(parametro))) {
                    resultados.add(material);
                }
            }

            if (!resultados.isEmpty()) {
                StringBuilder mensaje = new StringBuilder();
                for (Material material : resultados) {
                    mensaje.append(material.getDetalles()).append("\n");
                }
                JOptionPane.showMessageDialog(null, mensaje.toString(), "Resultados de búsqueda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron materiales con ese criterio.");
            }
        }
    }

    private Material buscarPorId(String id) {
        for (Material material : materiales) {
            if (material.getId().equals(id)) {
                return material;
            }
        }
        return null;
    }
}
