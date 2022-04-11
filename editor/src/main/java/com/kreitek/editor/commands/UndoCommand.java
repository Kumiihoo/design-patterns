package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {

    private final String data;

    public UndoCommand(String data) {
        this.data = data;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {

        boolean indice = documentLines.get(documentLines.size()-1).equals(data);

        if (documentLines.size() == 0){
            documentLines.add(data); // añadimos estado si la lista está vacía
        }else if (!indice){  // si es true elimina el último elemento de la lista y añade el estado
            documentLines.remove(documentLines.size()-1);
            documentLines.add(data);
        }else{
            documentLines.remove(data); // elimina el estado
        }

    }
}