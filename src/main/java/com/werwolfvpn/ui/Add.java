package com.werwolfvpn.ui;//======================================================
// Source code generated by jvider v1.8.1 UNREGISTERED version.
// http://www.jvider.com/
//======================================================
import com.opencsv.exceptions.CsvException;
import com.werwolfvpn.api.Create;
import com.werwolfvpn.api.GetServers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author  Administrator
 * @created September 26, 2021
 */
public class Add extends JDialog 
{
static Add theAdd;

JPanel pnPanel0;
JList tbTable0;
JButton btBut0;
/**
 */

/**
 */
public Add() throws IOException, CsvException {
   super();
   //super( OWNER, "TITLE", MODAL );

   pnPanel0 = new JPanel();
   pnPanel0.setBorder( BorderFactory.createTitledBorder( "Add" ) );
   GridBagLayout gbPanel0 = new GridBagLayout();
   GridBagConstraints gbcPanel0 = new GridBagConstraints();
   pnPanel0.setLayout( gbPanel0 );
   GetServers servers = new GetServers();
   servers.csvdownload();
   String csv = "";
   csv = servers.comp;
   String[] list = csv.replace("null", "").split(",");
   tbTable0 = new JList(list);
   JScrollPane scroll = new JScrollPane(tbTable0);
   String []colsTable0 = new String[] { "", "" };
   gbcPanel0.gridx = 0;
   gbcPanel0.gridy = 0;
   gbcPanel0.gridwidth = 20;
   gbcPanel0.gridheight = 18;
   gbcPanel0.fill = GridBagConstraints.BOTH;
   gbcPanel0.weightx = 1;
   gbcPanel0.weighty = 1;
   gbcPanel0.anchor = GridBagConstraints.NORTH;
   gbPanel0.setConstraints( tbTable0, gbcPanel0 );
   pnPanel0.add( scroll );

   btBut0 = new JButton( "Add"  );
   btBut0.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
         String selected = (String)tbTable0.getSelectedValue();
         if(!selected.equals("")) {
            Create create = new Create();
            String[] wand = selected.split(" - ");
            create.create(wand[1],wand[0] + ".opengw.net");
         }
      }
   });
   gbcPanel0.gridx = 4;
   gbcPanel0.gridy = 18;
   gbcPanel0.gridwidth = 11;
   gbcPanel0.gridheight = 2;
   gbcPanel0.fill = GridBagConstraints.BOTH;
   gbcPanel0.weightx = 1;
   gbcPanel0.weighty = 0;
   gbcPanel0.anchor = GridBagConstraints.NORTH;
   gbPanel0.setConstraints( btBut0, gbcPanel0 );
   pnPanel0.add( btBut0 );

   setDefaultCloseOperation( DISPOSE_ON_CLOSE );

   setContentPane( pnPanel0 );
   pack();
   setVisible( true );
   this.setSize(new Dimension(344,299));
}
} 
