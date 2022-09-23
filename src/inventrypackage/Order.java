/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventrypackage;

import Dialog.OrderQty;
import db.Database;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.String.format;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Amazoft
 */
public class Order extends javax.swing.JFrame {
    
        private Double totalamount, Needtoremovetot;
        
        Double totalAmount=0.0;
        Double cash=0.0;
        Double balance=0.0;
        Double bHeight=0.0;
    
    
    
    private DefaultTableModel dtm;
    private double completeTotal, completeTotalAfterRemove;
    

    /**
     * Creates new form Order
     */
    
    
    
    private void LoadProductData(){
        System.out.println("Running");
        ResultSet pd = Database.getData("SELECT * FROM PRICEBATCH PB INNER JOIN PRODUCTTBL PT ON PB.PRODCODE=PT.PRODCODE WHERE PB.PRODQTY>0 ");
//        dtm.setRowCount(0);
        try {
            while(pd.next()){
                
                Vector v = new Vector();
                v.add(pd.getString(2));
                v.add(pd.getString(7));
                v.add(pd.getInt(5));
                v.add(pd.getDouble(4));
                v.add(pd.getInt(1));
                v.add(pd.getDouble(3));
                
                dtm.addRow(v);
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
    private void InvoiceNumber(){
        ResultSet invoicenumber = Database.getData("SELECT ID FROM INVOICEDETAILS ORDER BY ID DESC fetch first 1 rows only");
        try {
            if(invoicenumber.next()){
                
                int InvoiceNumber = invoicenumber.getInt("ID"); 
                
                int invoicenumbercorrect = InvoiceNumber +1;
                
                InvoiceNumberLbl.setText(invoicenumbercorrect+"");
                 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
     
    public Order() {
        initComponents();
        dtm = (DefaultTableModel) ProductTable.getModel();
        
        LoadProductData();
        InvoiceNumber();
        
        GetToday();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        Home = new javax.swing.JButton();
        SearchArea = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        ClearProductSearchBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        InvoiceNumberLbl = new javax.swing.JLabel();
        Datelbl = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        TotalAmountLbl = new javax.swing.JLabel();
        CashAmount = new javax.swing.JTextField();
        TotalChangeLbl = new javax.swing.JLabel();
        CashBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        InvoiceProducttable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        SaveBtn = new javax.swing.JButton();
        ClearBtn = new javax.swing.JButton();
        ProductRemoveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1400, 900));

        jScrollPane2.setMinimumSize(new java.awt.Dimension(1024, 768));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel2.setPreferredSize(new java.awt.Dimension(1198, 813));

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(121, 76));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Invoice");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Product List");

        ProductTable.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Name", "Quantity", "Selling Price", "PriceBatchId", "CostPrice"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductTable.setRowHeight(25);
        ProductTable.setSelectionBackground(new java.awt.Color(0, 51, 102));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(3).setMinWidth(0);
            ProductTable.getColumnModel().getColumn(3).setPreferredWidth(0);
            ProductTable.getColumnModel().getColumn(3).setMaxWidth(0);
            ProductTable.getColumnModel().getColumn(4).setMinWidth(0);
            ProductTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            ProductTable.getColumnModel().getColumn(4).setMaxWidth(0);
            ProductTable.getColumnModel().getColumn(5).setMinWidth(0);
            ProductTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            ProductTable.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        Home.setBackground(new java.awt.Color(255, 255, 255));
        Home.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Home.setForeground(new java.awt.Color(0, 51, 102));
        Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home.png"))); // NOI18N
        Home.setText("Home");
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        SearchArea.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        SearchArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchAreaActionPerformed(evt);
            }
        });

        SearchBtn.setBackground(new java.awt.Color(255, 255, 255));
        SearchBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        ClearProductSearchBtn.setBackground(new java.awt.Color(255, 255, 255));
        ClearProductSearchBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ClearProductSearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/clear.png"))); // NOI18N
        ClearProductSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearProductSearchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SearchArea, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClearProductSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Home))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClearProductSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchArea, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Home)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Invoice NO :");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        InvoiceNumberLbl.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        InvoiceNumberLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InvoiceNumberLbl.setText("2022/IN/00001");

        Datelbl.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Datelbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InvoiceNumberLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(Datelbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvoiceNumberLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Datelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("INVOICE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("TOTAL :");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cash :");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total Change :");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        TotalAmountLbl.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        TotalAmountLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        CashAmount.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        CashAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CashAmount.setToolTipText("Enter payment price");

        TotalChangeLbl.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        TotalChangeLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        CashBtn.setBackground(new java.awt.Color(255, 255, 255));
        CashBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        CashBtn.setForeground(new java.awt.Color(0, 102, 51));
        CashBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/add.png"))); // NOI18N
        CashBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CashBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(CashAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CashBtn))
                    .addComponent(TotalChangeLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TotalAmountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TotalAmountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CashAmount)
                    .addComponent(CashBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalChangeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        InvoiceProducttable.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        InvoiceProducttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Name", "Quantity", "Unit Price", "Total", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InvoiceProducttable.setRowHeight(25);
        InvoiceProducttable.setSelectionBackground(new java.awt.Color(0, 51, 102));
        InvoiceProducttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InvoiceProducttableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InvoiceProducttableMouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(InvoiceProducttable);
        if (InvoiceProducttable.getColumnModel().getColumnCount() > 0) {
            InvoiceProducttable.getColumnModel().getColumn(5).setMinWidth(0);
            InvoiceProducttable.getColumnModel().getColumn(5).setPreferredWidth(0);
            InvoiceProducttable.getColumnModel().getColumn(5).setMaxWidth(0);
            InvoiceProducttable.getColumnModel().getColumn(6).setMinWidth(0);
            InvoiceProducttable.getColumnModel().getColumn(6).setPreferredWidth(0);
            InvoiceProducttable.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        SaveBtn.setBackground(new java.awt.Color(255, 255, 255));
        SaveBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        SaveBtn.setForeground(new java.awt.Color(0, 153, 102));
        SaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/done.png"))); // NOI18N
        SaveBtn.setText("Save & Print");
        SaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveBtnMouseClicked(evt);
            }
        });
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        ClearBtn.setBackground(new java.awt.Color(255, 255, 255));
        ClearBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ClearBtn.setForeground(new java.awt.Color(255, 0, 51));
        ClearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/clear.png"))); // NOI18N
        ClearBtn.setText("Clear");
        ClearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearBtnMouseClicked(evt);
            }
        });

        ProductRemoveBtn.setBackground(new java.awt.Color(255, 255, 255));
        ProductRemoveBtn.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        ProductRemoveBtn.setForeground(new java.awt.Color(255, 0, 51));
        ProductRemoveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/delete.png"))); // NOI18N
        ProductRemoveBtn.setText("Remove");
        ProductRemoveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductRemoveBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(ClearBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductRemoveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveBtn)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBtn)
                    .addComponent(ProductRemoveBtn)
                    .addComponent(ClearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 135, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GetToday(){
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        
        Datelbl.setText(dtf.format(now));
    }
    
    
    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
            
        String productcode = (String) ProductTable.getValueAt(ProductTable.getSelectedRow(), 0);
        String productname = (String) ProductTable.getValueAt(ProductTable.getSelectedRow(), 1);
        double selling = (double) ProductTable.getValueAt(ProductTable.getSelectedRow(), 3);
        int pbid = (int) ProductTable.getValueAt(ProductTable.getSelectedRow(), 4);
        double cost = (double) ProductTable.getValueAt(ProductTable.getSelectedRow(), 5);
        
        new OrderQty(this, rootPaneCheckingEnabled,selling,pbid,productname,productcode,cost).setVisible(true);
        
        
        calculateTotal();

    }//GEN-LAST:event_ProductTableMouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeMouseClicked

    
    public static void AddRowToJTable(Object[] dataRow){
        DefaultTableModel model = (DefaultTableModel)InvoiceProducttable.getModel();
        model.addRow(dataRow);
    }
    
    
    private void InvoiceProducttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvoiceProducttableMouseClicked
    
    }//GEN-LAST:event_InvoiceProducttableMouseClicked

    private void SaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveBtnMouseClicked

    
    public PageFormat getPageFormat(PrinterJob pj){
    
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();    

        double bodyHeight = bHeight;  
        double headerHeight = 5.0;                  
        double footerHeight = 5.0;        
        double width = cm_to_pp(8); 
        double height = cm_to_pp(headerHeight+bodyHeight+footerHeight); 
        paper.setSize(width, height);
        paper.setImageableArea(0,10,width,height - cm_to_pp(1));  

        pf.setOrientation(PageFormat.PORTRAIT);  
        pf.setPaper(paper);    

        return pf;
    }
    
    protected static double cm_to_pp(double cm){            
	return toPPI(cm * 0.393600787);            
    }
 
    protected static double toPPI(double inch){            
	return inch * 72d;            
    }
    
    public class BillPrintable implements Printable {
    
   
    
    
    public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
    throws PrinterException 
    {    
        
        ResultSet sd = Database.getData("SELECT * FROM SHOPDETAILS");
        try {
            if(sd.next()){
                
                int Shopid = sd.getInt("ID"); 
                String ShopName = sd.getString("SHOPNAME"); 
                String ShopAddress = sd.getString("SHOPADDRESS"); 
                String ShopRoad = sd.getString("SHOPROADNAME"); 
                String ShopCity = sd.getString("SHOPCITY"); 
                String ShopCountry = sd.getString("SHOPCOUNTRY"); 
                String ShopConNumber = sd.getString("SHOPCONTACTNUMBER"); 
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        int r= InvoiceProducttable.getRowCount();
//        int r= itemName.size();
        
//        ImageIcon icon=new ImageIcon("C:UsersccsDocumentsNetBeansProjectsvideo TestPOSInvoicesrcposinvoicemylogo.jpg"); 
        int result = NO_SUCH_PAGE;    
          if (pageIndex == 0) {                    

              Graphics2D g2d = (Graphics2D) graphics;                    
              double width = pageFormat.getImageableWidth();                               
              g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 



            //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));

          try{
              int y=20;
              int yShift = 10;
              int headerRectHeight=15;
             // int headerRectHeighta=40;
 

              g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
//              g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);y+=yShift+30;
              g2d.drawString("-------------------------------------",12,y);y+=yShift;
              g2d.drawString("            "+sd.getString("SHOPNAME")+"     ",12,y);y+=yShift;
              g2d.drawString("        "+sd.getString("SHOPADDRESS")+"      ",12,y);y+=yShift;
              g2d.drawString("      "+sd.getString("SHOPROADNAME")+"  ",12,y);y+=yShift;
              g2d.drawString("       "+sd.getString("SHOPCITY")+"   ",12,y);y+=yShift;
              g2d.drawString("           "+sd.getString("SHOPCOUNTRY")+"        ",12,y);y+=yShift;
//              g2d.drawString("  www.facebook.com/amazoft.sl ",12,y);y+=yShift;
              g2d.drawString("          "+sd.getString("SHOPCONTACTNUMBER")+"    ",12,y);y+=yShift;
              g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;

              g2d.drawString(" Item Name                  Price   ",10,y);y+=yShift;
              g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;

              for(int s=0; s<r; s++)
              {
                  
              g2d.drawString(" "+InvoiceProducttable.getValueAt(s, 1)+"                            ",10,y);y+=yShift;
              g2d.drawString("      "+InvoiceProducttable.getValueAt(s, 2)+" * "+InvoiceProducttable.getValueAt(s, 3),10,y); g2d.drawString(""+InvoiceProducttable.getValueAt(s, 4),160,y);y+=yShift;

              }

              g2d.drawString("-------------------------------------",10,y);y+=yShift;
              g2d.drawString(" Total amount:               "+TotalAmountLbl.getText()+"   ",10,y);y+=yShift;
              g2d.drawString("-------------------------------------",10,y);y+=yShift;
              g2d.drawString(" Cash      :                 "+CashAmount.getText()+".00   ",10,y);y+=yShift;
              g2d.drawString("-------------------------------------",10,y);y+=yShift;
              g2d.drawString(" Total Change:               "+TotalChangeLbl.getText()+"   ",10,y);y+=yShift;

              g2d.drawString("*************************************",10,y);y+=yShift;
              g2d.drawString("       THANK YOU COME AGAIN            ",10,y);y+=yShift;
              g2d.drawString("*************************************",10,y);y+=yShift;
              g2d.drawString("       SOFTWARE BY:AMAZOFT          ",10,y);y+=yShift;
              g2d.drawString("       CONTACT: 0771188218          ",10,y);y+=yShift;       
              g2d.drawString("     E-MAIL: info@amazoft.com       ",10,y);y+=yShift;       


      }
      catch(Exception e){
      e.printStackTrace();
      }

                result = PAGE_EXISTS;    
            }    
            return result;    
        }
     }
    
    
    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
       
        
        DefaultTableModel ipdmfs = (DefaultTableModel)InvoiceProducttable.getModel();
        
            if(InvoiceProducttable.getRowCount()==0){
                
                JOptionPane.showMessageDialog(this, "Order table is Empty!");
                
            }else{
                
                
                
                    if(Database.saveData("INSERT INTO INVOICEDETAILS VALUES (default,"+TotalAmountLbl.getText()+",'"+Datelbl.getText()+"')")){
        //            JOptionPane.showMessageDialog(rootPane, "Product Successfully Added.");
        //            System.out.println("Invoice Saved.");


                    ResultSet inum = Database.getData("SELECT ID FROM INVOICEDETAILS ORDER BY ID DESC fetch first 1 rows only");   
                    try {
                        if(inum.next()){

                            int orderid = inum.getInt("ID"); 

                                for(int i = 0;i< InvoiceProducttable.getRowCount();i++){

                                    String pcode = InvoiceProducttable.getValueAt(i, 0).toString();
                                    String pname = InvoiceProducttable.getValueAt(i, 1).toString();
                                    String pqty = InvoiceProducttable.getValueAt(i, 2).toString();
                                    double uprice = (double) InvoiceProducttable.getValueAt(i, 3);
                                    double tprice = (double) InvoiceProducttable.getValueAt(i, 4);
                                    String pbatch = InvoiceProducttable.getValueAt(i, 5).toString();
                                    double costtotal = (double) InvoiceProducttable.getValueAt(i, 6);


                                    if(Database.saveData("INSERT INTO INVOICEPRODUCT VALUES (default, "+orderid+" , '"+pcode+"' , "+pqty+" , "+uprice+" , "+tprice+" , '"+Datelbl.getText()+"' , '"+pname+"' , "+pbatch+" , "+costtotal+" )")){
        //                                JOptionPane.showMessageDialog(rootPane, "Product Successfully Added.");
                                        System.out.println("Invoice Saved.");

                                            if(Database.saveData("UPDATE PRICEBATCH SET PRODQTY = PRODQTY - "+pqty+" WHERE ID="+pbatch+" ")){

                                                if(Database.saveData("UPDATE PRODUCTTBL SET PRODQTY = PRODQTY - "+pqty+" WHERE PRODCODE='"+pcode+"'")){
        //                                            JOptionPane.showMessageDialog(rootPane, "Quantity Successfully Added.");
                                                    System.out.println("Quantity Successfully Removed");

                                                }else{
                                                    JOptionPane.showMessageDialog(rootPane, "FAILED CODE PATHFINDER");
                                                    System.out.println("FAILED CODE PATHFINDER");
                                                }

                                            }else{
                                                JOptionPane.showMessageDialog(rootPane, "Failed CODE COKE");
                                                System.out.println("FAILED CODE COKE");
                                            }

                                    }else{

                                        JOptionPane.showMessageDialog(rootPane, "FAILED CODE: SNAKE");
                                        System.out.println("FAILED CODE: SNAKE");
                                    }

                                }

                                JOptionPane.showMessageDialog(rootPane, "Invoice Saved.");

//                                try{
//
//                                    InvoiceProducttable.print();
//
//                                }catch (Exception ex) {
//                                    ex.printStackTrace();
//                                }


                                bHeight = Double.valueOf(InvoiceProducttable.getRowCount());
                                //JOptionPane.showMessageDialog(rootPane, bHeight);

                                PrinterJob pj = PrinterJob.getPrinterJob();        
                                pj.setPrintable(new BillPrintable(),getPageFormat(pj));
                                try {
                                     pj.print();

                                }
                                 catch (PrinterException ex) {
                                         ex.printStackTrace();
                                }



                                new Home().setVisible(true);
                                this.dispose();







                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }






                }else{
                    JOptionPane.showMessageDialog(rootPane, "FAILED CODE: SPRITE");
                    System.out.println("FAILED CODE: SPRITE");
                }
                    
                    
                    
                    
                
                
            }
        
        
        
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void InvoiceProducttableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InvoiceProducttableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_InvoiceProducttableMouseEntered

    private void ClearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearBtnMouseClicked
        DefaultTableModel dm = (DefaultTableModel)InvoiceProducttable.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged(); // notifies the JTable that the model has changed
        TotalAmountLbl.setText("0.00");
    }//GEN-LAST:event_ClearBtnMouseClicked

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeActionPerformed

    private void ProductRemoveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductRemoveBtnMouseClicked
        DefaultTableModel ipdm = (DefaultTableModel)InvoiceProducttable.getModel();
        
        
        if(InvoiceProducttable.getSelectedRowCount()==1){
            ipdm.removeRow(InvoiceProducttable.getSelectedRow());
            calculateTotal();
            
        }else{
            if(InvoiceProducttable.getRowCount()==0){
                JOptionPane.showMessageDialog(this, "Order table is Empty!");
            }else{
                JOptionPane.showMessageDialog(this, "Please select single row for delete.");
            }
        }
    }//GEN-LAST:event_ProductRemoveBtnMouseClicked

    private void CashBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CashBtnMouseClicked
        
        double totalinvoiceprice = Double.parseDouble(TotalAmountLbl.getText());
        double cashpay = Double.parseDouble(CashAmount.getText());
        
        if(cashpay < totalinvoiceprice){
            JOptionPane.showMessageDialog(this, "Total value is greater than paying value.");
        }else{
            
            double TotAmountBill = (cashpay - totalinvoiceprice);
            TotalChangeLbl.setText(format("%.2f",TotAmountBill));

            //Open Cash Drawer
//              byte[] open = {27,112,0,100,(byte) 250};
            //http://keyhut.com/popopen4.htm
        }
        
    }//GEN-LAST:event_CashBtnMouseClicked

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        
        
        
        if(SearchArea.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the product code to search.");
        }else{
            
            String SearchKeyWord = SearchArea.getText();
            
            ResultSet pd = Database.getData("SELECT * FROM PRICEBATCH PB INNER JOIN PRODUCTTBL PT ON PB.PRODCODE=PT.PRODCODE WHERE PB.PRODQTY > 0 AND PB.PRODCODE='"+SearchKeyWord+"' ");
    //        pd.setRowCount(0);
            DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
            model.setRowCount(0);
            try {
                while(pd.next()){

                    Vector v = new Vector();
                    v.add(pd.getString(2));
                    v.add(pd.getString(7));
                    v.add(pd.getInt(5));
                    v.add(pd.getDouble(4));
                    v.add(pd.getInt(1));
                    v.add(pd.getDouble(3));

                    model.addRow(v);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        }
        
        
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void SearchAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchAreaActionPerformed
        
        if(SearchArea.getText().isEmpty()){
            
            ResultSet pd = Database.getData("SELECT * FROM PRICEBATCH PB INNER JOIN PRODUCTTBL PT ON PB.PRODCODE=PT.PRODCODE WHERE PB.PRODQTY > 0 ");
    //        pd.setRowCount(0);
            DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
            model.setRowCount(0);
            try {
                while(pd.next()){

                    Vector v = new Vector();
                    v.add(pd.getString(2));
                    v.add(pd.getString(7));
                    v.add(pd.getInt(5));
                    v.add(pd.getDouble(4));
                    v.add(pd.getInt(1));
                    v.add(pd.getDouble(3));

                    model.addRow(v);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
        }else{
            
            String SearchKeyWord = SearchArea.getText();
            
            ResultSet pd = Database.getData("SELECT * FROM PRICEBATCH PB INNER JOIN PRODUCTTBL PT ON PB.PRODCODE=PT.PRODCODE WHERE PB.PRODQTY > 0 AND PB.PRODCODE='"+SearchKeyWord+"' ");
    //        pd.setRowCount(0);
            DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
            model.setRowCount(0);
            try {
                while(pd.next()){

                    Vector v = new Vector();
                    v.add(pd.getString(2));
                    v.add(pd.getString(7));
                    v.add(pd.getInt(5));
                    v.add(pd.getDouble(4));
                    v.add(pd.getInt(1));
                    v.add(pd.getDouble(3));

                    model.addRow(v);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
            
        }
        
    }//GEN-LAST:event_SearchAreaActionPerformed

    private void ClearProductSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearProductSearchBtnActionPerformed
        
        ResultSet pd = Database.getData("SELECT * FROM PRICEBATCH PB INNER JOIN PRODUCTTBL PT ON PB.PRODCODE=PT.PRODCODE WHERE PB.PRODQTY > 0 ");
    //        pd.setRowCount(0);
            DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
            model.setRowCount(0);
            try {
                while(pd.next()){

                    Vector v = new Vector();
                    v.add(pd.getString(2));
                    v.add(pd.getString(7));
                    v.add(pd.getInt(5));
                    v.add(pd.getDouble(4));
                    v.add(pd.getInt(1));
                    v.add(pd.getDouble(3));

                    model.addRow(v);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        SearchArea.setText("");
        
    }//GEN-LAST:event_ClearProductSearchBtnActionPerformed

    private void calculateTotal() {
        
            double total = 0;
            completeTotal = 0;

            for(int i = 0;i<InvoiceProducttable.getRowCount();i++){
            double d = (double) InvoiceProducttable.getValueAt(i, 4);
            
            total += d;
        
        }
        
        completeTotal = total;
        TotalAmountLbl.setText(format("%.2f", completeTotal));
        
        
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CashAmount;
    private javax.swing.JButton CashBtn;
    private javax.swing.JButton ClearBtn;
    private javax.swing.JButton ClearProductSearchBtn;
    private javax.swing.JLabel Datelbl;
    private javax.swing.JButton Home;
    private javax.swing.JLabel InvoiceNumberLbl;
    private static javax.swing.JTable InvoiceProducttable;
    private javax.swing.JButton ProductRemoveBtn;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField SearchArea;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JLabel TotalAmountLbl;
    private javax.swing.JLabel TotalChangeLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    
}
