package com.ningyi.sql2xml.wrapper;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.components.JBScrollPane;
import com.ningyi.sql2xml.convert.ConvertXML;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class HomeDialogWrapper extends DialogWrapper {
    private JTextArea textArea;
    private JTextArea previewArea;

    public HomeDialogWrapper() {
        super(true);
        init();
        setTitle("S2X");
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        JBScrollPane scrollPane = new JBScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        previewArea = new JTextArea();
        previewArea.setEditable(false);

        JBScrollPane previewScrollPane = new JBScrollPane(previewArea);
        previewScrollPane.setPreferredSize(new Dimension(400, 200));

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updatePreview();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updatePreview();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updatePreview();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.NORTH);
        panel.add(previewScrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void updatePreview() {
        String text = textArea.getText();
        ConvertXML convertXML =new ConvertXML();
        convertXML.toXML(text);
        previewArea.setText(text);
    }
}
