package com.ningyi.sql2xml.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.EditorTextField;
import com.intellij.ui.components.JBScrollPane;
import com.ningyi.sql2xml.wrapper.HomeDialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class PopUpMenuAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        HomeDialogWrapper homeDialogWrapper = new HomeDialogWrapper();
        homeDialogWrapper.show();
    }
}
