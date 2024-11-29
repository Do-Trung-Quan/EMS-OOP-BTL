package gui;

import Class.NhanVien;
import Class.DSLuong;
import Class.DSAccount;
import Class.DSDuAn;
import Class.DSNhanVien;
import Class.DSPhongBan;
import Class.DuAn;
import Class.PhongBan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class AdminFrame1 extends javax.swing.JFrame {
    private NhanVien nv;
    private DSNhanVien dsNV;
    private DSLuong dsL;
    private DSAccount dsA;
    private DSPhongBan dsPB;
    private DSDuAn dsDA;
    private JPanel glassPane;
    /**
     * Creates new form ChuyenVienFrame1
     */
    public AdminFrame1(NhanVien nv, DSNhanVien dsNV, DSLuong dsL, DSAccount dsA) {
        this.nv = nv;
        this.dsNV = dsNV;
        this.dsL = dsL;
        this.dsA = dsA;
        this.dsPB = new DSPhongBan();
        this.dsDA = new DSDuAn();
        
        //--Doc File PhongBan vào dsPB
        //Setup data từng phòng ban
        try {
            //Đặt lại biến static cnt để tạo maPB từ đầu
            PhongBan tmp = new PhongBan();
            tmp.setupCnt();
            
            Scanner in = new Scanner(new File("PB.txt"));
            while(in.hasNextLine()){
                String[] line = in.nextLine().trim().split("\\|");
                PhongBan pb = new PhongBan(line[0]);
                for(int i=1;i<line.length;i++){
                    pb.addNhanVien(dsNV.searchNhanVien(line[i]));
                }
                dsPB.addPhongBan(pb);
            }
        } catch (FileNotFoundException e) {
        }
        
        //--Doc File DuAn vao dsDA
        dsDA.readFile();
        
        initComponents();
        setData();
    }
    
    private void ResetTablePB(){
        DefaultTableModel modelDSPB = (DefaultTableModel)DSPhongBanTable.getModel();
        modelDSPB.setRowCount(0);
        int cnt = 1;
        for(PhongBan x:dsPB.getDSPhongBan()){
            modelDSPB.addRow(new Object[]{cnt++, x.getMaPhongBan(), x.getTenPhongBan(),x.getDSNhanVien().size()});
        }
    }
    
    private void ResetTableNVPB(){
        DefaultTableModel modelNVPB = (DefaultTableModel)NhanVienPBTable.getModel();
        modelNVPB.setRowCount(0);
        PhongBan pb = dsPB.SearchPhongBan(MaPBText.getText());
//        int cnt = 1;
        for(NhanVien x:pb.getDSNhanVien()){
            modelNVPB.addRow(x.getData());
        }
    }
    
    private void SetupNonNVPBTable(){
        DefaultTableModel modelNonNVPB = (DefaultTableModel)NonNVPBTable.getModel();
        modelNonNVPB.setRowCount(0);
        for(NhanVien x:dsNV.getDSNhanVien()){
            int ok = 0;
            for(PhongBan y:dsPB.getDSPhongBan()){
                if(y.getDSNhanVien().contains(x)){
                    ok=1;
                    break;
                }
            }
            if(ok==0) modelNonNVPB.addRow(x.getData());
        }
    }
    
    private void setData(){
        glassPane = new JPanel();
        glassPane.setOpaque(false); // Glass pane trong suốt
        glassPane.setLayout(new GridBagLayout());

        // Chặn sự kiện chuột
        glassPane.addMouseListener(new MouseAdapter() {}); 
        glassPane.addKeyListener(new KeyAdapter() {});
        glassPane.add(ThemSuaPanel);
        setGlassPane(glassPane);
        glassPane.setVisible(false);
        ThemSuaPanel.setVisible(false);
        
        
        
        //Setup DSPhongBan, DSNonNVPB 
        ResetTablePB();
        SetupNonNVPBTable();
        
        
        
//        //cập nhật thông tin phòng ban
//        MaPBText.setText("PB01");
//        TenPBText.setText("Nhân sự");
//        
//        //cập nhật danh sách nhân viên phòng ban
//        DefaultTableModel model = new DefaultTableModel();
//        NhanVienPBTable.setModel(model);
//        model.setColumnIdentifiers(new String [] {"Mã NV", "Tên NV", "Chức vụ", "Giới tính", "Email", "SDT", "Ngày sinh", "Ngày Bắt Đầu"});
////        model.setRowCount(0);
//        for(NhanVien x:dsNV.getDSNhanVien()){
//            model.addRow(x.getData());
//        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        AppName = new javax.swing.JLabel();
        SubAppName = new javax.swing.JLabel();
        Sidebar = new javax.swing.JPanel();
        SidebarPhongBan = new javax.swing.JButton();
        SidebarTTCN = new javax.swing.JButton();
        SidebarDuAn = new javax.swing.JButton();
        LogoutButton = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        QuanLyPhongBan = new javax.swing.JTabbedPane();
        DSPhongBan = new javax.swing.JPanel();
        ThemSuaPanel = new javax.swing.JPanel();
        XacNhanButton = new javax.swing.JButton();
        HuyButton = new javax.swing.JButton();
        ThemSuaTitle = new javax.swing.JLabel();
        TenTPLabel = new javax.swing.JLabel();
        TenPBtext = new javax.swing.JTextField();
        DSPhongBanTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DSPhongBanTable = new javax.swing.JTable();
        ThemButton = new javax.swing.JButton();
        XoaButton = new javax.swing.JButton();
        SuaButton = new javax.swing.JButton();
        SearchPBButton = new javax.swing.JButton();
        SearchPBText = new javax.swing.JTextField();
        DSNVLabel1 = new javax.swing.JLabel();
        ChucNangLabel = new javax.swing.JLabel();
        TTChiTietButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JLabel();
        PhongBan = new javax.swing.JPanel();
        ThemNVPBPanel = new javax.swing.JPanel();
        ThemNVPBTitle1 = new javax.swing.JLabel();
        HuyNVPBButton = new javax.swing.JButton();
        XacNhanNVPBButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        NonNVPBTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NhanVienPBTable = new javax.swing.JTable();
        SearchNVPBText = new javax.swing.JTextField();
        SearchNVPBButton = new javax.swing.JButton();
        PBTitle = new javax.swing.JLabel();
        MaPBLabel = new javax.swing.JLabel();
        MaPBText = new javax.swing.JLabel();
        DSNVLabel = new javax.swing.JLabel();
        TenPBLabel = new javax.swing.JLabel();
        TenPBText = new javax.swing.JLabel();
        ThemNVPBButton = new javax.swing.JButton();
        XoaNVPBButton = new javax.swing.JButton();
        ChucNangLabel1 = new javax.swing.JLabel();
        ResetNVPBButton = new javax.swing.JLabel();
        BackNVPBButton = new javax.swing.JLabel();
        TTCN = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        DSDuAN = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EMS");
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(205, 225, 238));
        jPanel2.setMaximumSize(new java.awt.Dimension(230, 632));
        jPanel2.setMinimumSize(new java.awt.Dimension(230, 632));
        jPanel2.setPreferredSize(new java.awt.Dimension(230, 632));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(74, 98, 138));
        Header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AppName.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        AppName.setForeground(new java.awt.Color(255, 255, 255));
        AppName.setText("EMS");
        Header.add(AppName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        SubAppName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SubAppName.setForeground(new java.awt.Color(205, 225, 238));
        SubAppName.setText("CLC-02");
        Header.add(SubAppName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jPanel2.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 50));

        Sidebar.setBackground(new java.awt.Color(144, 176, 194));
        Sidebar.setMinimumSize(new java.awt.Dimension(240, 240));
        Sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SidebarPhongBan.setBackground(new java.awt.Color(144, 176, 194));
        SidebarPhongBan.setText("PHÒNG BAN");
        SidebarPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SidebarPhongBanActionPerformed(evt);
            }
        });
        Sidebar.add(SidebarPhongBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 240, 70));

        SidebarTTCN.setBackground(new java.awt.Color(144, 176, 194));
        SidebarTTCN.setText("THÔNG TIN CÁ NHÂN");
        SidebarTTCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SidebarTTCNMouseClicked(evt);
            }
        });
        SidebarTTCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SidebarTTCNActionPerformed(evt);
            }
        });
        Sidebar.add(SidebarTTCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 240, 70));

        SidebarDuAn.setBackground(new java.awt.Color(144, 176, 194));
        SidebarDuAn.setText("DỰ ÁN");
        SidebarDuAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SidebarDuAnActionPerformed(evt);
            }
        });
        Sidebar.add(SidebarDuAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 240, 70));

        LogoutButton.setBackground(new java.awt.Color(0, 0, 0));
        LogoutButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logout.png"))); // NOI18N
        LogoutButton.setText("LOGOUT");
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseEntered(evt);
            }
        });
        Sidebar.add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));

        jPanel2.add(Sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 240, 700));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setText("EMPLOYEES MANAGEMENT SYSTEM");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setText("Copyright - nhóm 8 OOP-BTL E22CQCN02-B PTIT 2024");

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addGap(293, 293, 293))
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel2.add(Footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1200, 100));

        DSPhongBan.setBackground(new java.awt.Color(228, 238, 244));
        DSPhongBan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ThemSuaPanel.setBackground(new java.awt.Color(144, 210, 254));
        ThemSuaPanel.setLayout(new java.awt.GridBagLayout());

        XacNhanButton.setText("Xác nhận");
        XacNhanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XacNhanButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(48, 91, 20, 0);
        ThemSuaPanel.add(XacNhanButton, gridBagConstraints);

        HuyButton.setText("Hủy");
        HuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuyButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(48, 112, 20, 0);
        ThemSuaPanel.add(HuyButton, gridBagConstraints);

        ThemSuaTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        ThemSuaTitle.setText("Thêm thông tin phòng ban mới");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 67, 0, 71);
        ThemSuaPanel.add(ThemSuaTitle, gridBagConstraints);

        TenTPLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TenTPLabel.setText("Tên phòng ban:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(47, 67, 0, 0);
        ThemSuaPanel.add(TenTPLabel, gridBagConstraints);

        TenPBtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TenPBtextActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 122;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 18, 0, 71);
        ThemSuaPanel.add(TenPBtext, gridBagConstraints);

        DSPhongBan.add(ThemSuaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 470, 210));

        DSPhongBanTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DSPhongBanTitle.setText("QUẢN LÝ PHÒNG BAN");
        DSPhongBan.add(DSPhongBanTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        DSPhongBanTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DSPhongBanTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MaPB", "Tên PB", "Tổng số nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DSPhongBanTable.setRowHeight(50);
        jScrollPane2.setViewportView(DSPhongBanTable);

        DSPhongBan.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 900, 360));

        ThemButton.setText("Thêm");
        ThemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemButtonActionPerformed(evt);
            }
        });
        DSPhongBan.add(ThemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, -1, -1));

        XoaButton.setText("Xóa");
        XoaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaButtonActionPerformed(evt);
            }
        });
        DSPhongBan.add(XoaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));

        SuaButton.setText("Sửa");
        SuaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaButtonActionPerformed(evt);
            }
        });
        DSPhongBan.add(SuaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, -1, -1));

        SearchPBButton.setText("Tìm");
        SearchPBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPBButtonActionPerformed(evt);
            }
        });
        DSPhongBan.add(SearchPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, -1, 20));

        SearchPBText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPBTextActionPerformed(evt);
            }
        });
        DSPhongBan.add(SearchPBText, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 240, -1));

        DSNVLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        DSNVLabel1.setText("Bấm nút bên để truy cập riêng từng phòng ban:");
        DSPhongBan.add(DSNVLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        ChucNangLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ChucNangLabel.setText("Chức năng:");
        DSPhongBan.add(ChucNangLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        TTChiTietButton.setText("Thông tin chi tiết");
        TTChiTietButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTChiTietButtonActionPerformed(evt);
            }
        });
        DSPhongBan.add(TTChiTietButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        ResetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Reset.png"))); // NOI18N
        ResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetButtonMouseClicked(evt);
            }
        });
        DSPhongBan.add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 30, 30));

        QuanLyPhongBan.addTab("tab1.1", DSPhongBan);

        PhongBan.setBackground(new java.awt.Color(228, 238, 244));
        PhongBan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ThemNVPBPanel.setBackground(new java.awt.Color(144, 210, 254));
        ThemNVPBPanel.setLayout(new java.awt.GridBagLayout());

        ThemNVPBTitle1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ThemNVPBTitle1.setText("Thêm nhân viên mới vào phòng ban");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 117, 0, 0);
        ThemNVPBPanel.add(ThemNVPBTitle1, gridBagConstraints);

        HuyNVPBButton.setText("Hủy");
        HuyNVPBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HuyNVPBButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 83, 24, 0);
        ThemNVPBPanel.add(HuyNVPBButton, gridBagConstraints);

        XacNhanNVPBButton.setText("Xác nhận");
        XacNhanNVPBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XacNhanNVPBButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 77, 24, 0);
        ThemNVPBPanel.add(XacNhanNVPBButton, gridBagConstraints);

        NonNVPBTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Chức vụ", "Giới tính", "Email", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        NonNVPBTable.setRowHeight(25);
        jScrollPane3.setViewportView(NonNVPBTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 520;
        gridBagConstraints.ipady = 285;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 53, 0, 51);
        ThemNVPBPanel.add(jScrollPane3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Danh sách nhân viên chưa thuộc phòng ban nào:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 53, 0, 0);
        ThemNVPBPanel.add(jLabel1, gridBagConstraints);

        PhongBan.add(ThemNVPBPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 640, 480));

        NhanVienPBTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Chức vụ", "Giới tính", "Email", "SDT", "Ngày sinh", "Ngày Bắt Đầu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        NhanVienPBTable.setRowHeight(25);
        jScrollPane1.setViewportView(NhanVienPBTable);
        if (NhanVienPBTable.getColumnModel().getColumnCount() > 0) {
            NhanVienPBTable.getColumnModel().getColumn(2).setHeaderValue("Chức vụ");
            NhanVienPBTable.getColumnModel().getColumn(3).setHeaderValue("Giới tính");
            NhanVienPBTable.getColumnModel().getColumn(4).setHeaderValue("Email");
            NhanVienPBTable.getColumnModel().getColumn(5).setHeaderValue("SDT");
            NhanVienPBTable.getColumnModel().getColumn(6).setHeaderValue("Ngày sinh");
            NhanVienPBTable.getColumnModel().getColumn(7).setHeaderValue("Ngày Bắt Đầu");
        }

        PhongBan.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 900, 360));

        SearchNVPBText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchNVPBTextActionPerformed(evt);
            }
        });
        PhongBan.add(SearchNVPBText, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 240, -1));

        SearchNVPBButton.setText("Tìm");
        SearchNVPBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchNVPBButtonActionPerformed(evt);
            }
        });
        PhongBan.add(SearchNVPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 160, -1, 20));

        PBTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PBTitle.setText("THÔNG TIN PHÒNG BAN");
        PhongBan.add(PBTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        MaPBLabel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        MaPBLabel.setText("Mã phòng ban:");
        PhongBan.add(MaPBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        MaPBText.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        MaPBText.setText("null");
        PhongBan.add(MaPBText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        DSNVLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        DSNVLabel.setText("Danh sách nhân viên thuộc phòng ban:");
        PhongBan.add(DSNVLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        TenPBLabel.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        TenPBLabel.setText("Tên phòng ban:");
        PhongBan.add(TenPBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        TenPBText.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        TenPBText.setText("null");
        PhongBan.add(TenPBText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        ThemNVPBButton.setText("Thêm");
        ThemNVPBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemNVPBButtonActionPerformed(evt);
            }
        });
        PhongBan.add(ThemNVPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, -1, -1));

        XoaNVPBButton.setText("Xóa");
        XoaNVPBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaNVPBButtonActionPerformed(evt);
            }
        });
        PhongBan.add(XoaNVPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, -1));

        ChucNangLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ChucNangLabel1.setText("Chức năng:");
        PhongBan.add(ChucNangLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        ResetNVPBButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Reset.png"))); // NOI18N
        ResetNVPBButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResetNVPBButtonMouseClicked(evt);
            }
        });
        PhongBan.add(ResetNVPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 30, 30));

        BackNVPBButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back.png"))); // NOI18N
        BackNVPBButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackNVPBButtonMouseClicked(evt);
            }
        });
        PhongBan.add(BackNVPBButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 30, 30));

        QuanLyPhongBan.addTab("tab1.2", PhongBan);

        jTabbedPane2.addTab("tab1", QuanLyPhongBan);

        TTCN.setBackground(new java.awt.Color(228, 238, 244));
        TTCN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Mã Nhân Viên:");
        TTCN.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("null");
        TTCN.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Họ và Tên:");
        TTCN.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("null");
        TTCN.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Giới tính:");
        TTCN.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("null");
        TTCN.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Ngày sinh:");
        TTCN.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("null");
        TTCN.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Số điện thoại:");
        TTCN.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("null");
        TTCN.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Email:");
        TTCN.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setText("null");
        TTCN.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setText("Lương cơ bản:");
        TTCN.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setText("null");
        TTCN.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setText("Phụ cấp:");
        TTCN.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("null");
        TTCN.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Ngày bắt đầu làm việc:");
        TTCN.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("null");
        TTCN.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, -1, -1));

        jTabbedPane2.addTab("tab2", TTCN);

        DSDuAN.setBackground(new java.awt.Color(228, 238, 244));
        DSDuAN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });
        DSDuAN.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 170, 110));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        DSDuAN.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 170, 110));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        DSDuAN.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 170, 110));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        DSDuAN.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 170, 110));

        jTabbedPane2.addTab("tab3", DSDuAN);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, -40, 960, 730));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 690));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_LogoutButtonMouseEntered
 
    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked
        // TODO add your handling code here:
        int tmp = JOptionPane.showConfirmDialog(this,"Confirm Logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if ( tmp == 0 ) {
            new Login(dsNV, dsA, dsL).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LogoutButtonMouseClicked

    private void SidebarDuAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SidebarDuAnActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_SidebarDuAnActionPerformed

    private void SidebarTTCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SidebarTTCNActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_SidebarTTCNActionPerformed

    private void SidebarPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SidebarPhongBanActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_SidebarPhongBanActionPerformed

    private void SidebarTTCNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SidebarTTCNMouseClicked

    }//GEN-LAST:event_SidebarTTCNMouseClicked

    private void SearchNVPBTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchNVPBTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchNVPBTextActionPerformed
    
    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
//        new ChuyenVienFrame3().setVisible(true);
        
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
//        new ChuyenVienFrame3().setVisible(true);
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
//        new ChuyenVienFrame3().setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:

//        new ChuyenVienFrame3().setVisible(true);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground( new Color(112, 132, 165));
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground( new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        // TODO add your handling code here:
        jPanel12.setBackground( new Color(112, 132, 165));
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        // TODO add your handling code here:
        jPanel12.setBackground( new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
         jPanel6.setBackground( new Color(112, 132, 165));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
         jPanel6.setBackground( new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
        jPanel7.setBackground( new Color(112, 132, 165));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
         jPanel7.setBackground( new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel7MouseExited

    private void SearchNVPBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchNVPBButtonActionPerformed
        // TODO add your handling code here:
        String searchText = SearchNVPBText.getText();
        if(!searchText.equals("")){
            DefaultTableModel modelNVPB = (DefaultTableModel)NhanVienPBTable.getModel();
            modelNVPB.setRowCount(0);
            PhongBan pb = dsPB.SearchPhongBan(MaPBText.getText());
            for(NhanVien x:pb.getDSNhanVien()){
                if(x.getMaNV().equals(searchText) || x.getTenNV().equals(searchText)){
                    modelNVPB.addRow(x.getData());
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!");
        }
    }//GEN-LAST:event_SearchNVPBButtonActionPerformed

    private void ThemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemButtonActionPerformed
        // TODO add your handling code here:
        glassPane.setVisible(true);
        ThemSuaPanel.setVisible(true);
        ThemSuaTitle.setText("Thêm thông tin phòng ban mới");
        TenPBtext.setText("");
    }//GEN-LAST:event_ThemButtonActionPerformed

    private void HuyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyButtonActionPerformed
        // TODO add your handling code here:
        glassPane.setVisible(false);
        ThemSuaPanel.setVisible(false);
    }//GEN-LAST:event_HuyButtonActionPerformed

    private void XacNhanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XacNhanButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelDSPB = (DefaultTableModel)DSPhongBanTable.getModel();
        if(TenPBtext.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Xin hãy thêm đủ thông tin!");
        }else{
            if(ThemSuaTitle.getText().equals("Chỉnh sửa thông tin phòng ban")){
                String newName = TenPBtext.getText();
                for(PhongBan x:dsPB.getDSPhongBan()){
                    if(x.getMaPhongBan().equals(modelDSPB.getValueAt(DSPhongBanTable.getSelectedRow(), 1))){
                        x.setTenPhongBan(newName);
                        newName = x.getTenPhongBan();
                        break;
                    }
                }
                dsPB.writeFile(); //Ghi File sau khi chỉnh sửa
                modelDSPB.setValueAt(newName,DSPhongBanTable.getSelectedRow(), 2); 
                ThemSuaPanel.setVisible(false);
            }else{
                String newName = TenPBtext.getText();
                PhongBan newPB = new PhongBan(newName);
                dsPB.addPhongBan(newPB);
                dsPB.writeFile(); //Ghi File sau khi chỉnh sửa
                Object[] newPBData = {DSPhongBanTable.getRowCount()+1, newPB.getMaPhongBan(), newPB.getTenPhongBan(), 0};
                modelDSPB.addRow(newPBData);
                ThemSuaPanel.setVisible(false);
            }
            glassPane.setVisible(false);
        }
    }//GEN-LAST:event_XacNhanButtonActionPerformed

    private void SuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaButtonActionPerformed
        // TODO add your handling code here:
        
        
        if(DSPhongBanTable.getSelectedRowCount()==1){
            DefaultTableModel modelDSPB = (DefaultTableModel)DSPhongBanTable.getModel();
            ThemSuaTitle.setText("Chỉnh sửa thông tin phòng ban");
            String tblTenPB = modelDSPB.getValueAt(DSPhongBanTable.getSelectedRow(), 2).toString();
            TenPBtext.setText(tblTenPB);
            glassPane.setVisible(true);
            ThemSuaPanel.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 phòng ban để chỉnh sửa!");
        }
    }//GEN-LAST:event_SuaButtonActionPerformed

    private void XoaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaButtonActionPerformed
        // TODO add your handling code here:
        if(DSPhongBanTable.getSelectedRowCount()==1){
            DefaultTableModel modelDSPB = (DefaultTableModel)DSPhongBanTable.getModel();
            dsPB.removePhongBan(dsPB.SearchPhongBan(DSPhongBanTable.getValueAt(DSPhongBanTable.getSelectedRow(), 1).toString())); //Xóa Phòng ban đang chọn trong dsPB
            dsPB.writeFile(); //Ghi File sau khi chỉnh sửa
            modelDSPB.removeRow(DSPhongBanTable.getSelectedRow()); //Xóa Phòng ban đang chọn trong giao diện
            for(int i=1;i<=DSPhongBanTable.getRowCount();i++){
                modelDSPB.setValueAt(i, i-1, 0);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 phòng ban để xóa!");
        }

    }//GEN-LAST:event_XoaButtonActionPerformed

    private void SearchPBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPBButtonActionPerformed
        // TODO add your handling code here:
        String searchText = SearchPBText.getText();
        if(!searchText.equals("")){
            DefaultTableModel modelDSPB = (DefaultTableModel)DSPhongBanTable.getModel();
            modelDSPB.setRowCount(0);
            for(PhongBan x:dsPB.getDSPhongBan()){
                if(x.getMaPhongBan().equals(searchText) || x.getTenPhongBan().equals(searchText)){
                    Object[] newPBData = {DSPhongBanTable.getRowCount()+1, x.getMaPhongBan(), x.getTenPhongBan(), x.getDSNhanVien().size()};
                    modelDSPB.addRow(newPBData);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin!");
        }
    }//GEN-LAST:event_SearchPBButtonActionPerformed

    private void SearchPBTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPBTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPBTextActionPerformed

    private void TTChiTietButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTChiTietButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelNVPB = (DefaultTableModel)NhanVienPBTable.getModel();
        if(DSPhongBanTable.getSelectedRowCount()==1){
            int ind = DSPhongBanTable.getSelectedRow();
            String MaPB = DSPhongBanTable.getValueAt(ind, 1).toString();
            PhongBan pb = dsPB.SearchPhongBan(MaPB);
            
            MaPBText.setText(pb.getMaPhongBan());
            TenPBText.setText(pb.getTenPhongBan());
            modelNVPB.setRowCount(0);
            for(NhanVien x:pb.getDSNhanVien()){
                modelNVPB.addRow(x.getData());
            }
            glassPane.remove(ThemSuaPanel);
            glassPane.add(ThemNVPBPanel);
            ThemNVPBPanel.setVisible(false);
            QuanLyPhongBan.setSelectedIndex(1);
            
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 phòng ban để truy cập!");
        }
    }//GEN-LAST:event_TTChiTietButtonActionPerformed

    private void TenPBtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TenPBtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TenPBtextActionPerformed

    private void ResetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetButtonMouseClicked
        // TODO add your handling code here:
        ResetTablePB();
    }//GEN-LAST:event_ResetButtonMouseClicked

    private void ThemNVPBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemNVPBButtonActionPerformed
        // TODO add your handling code here:
        SetupNonNVPBTable();
        glassPane.setVisible(true);
        ThemNVPBPanel.setVisible(true);
        
    }//GEN-LAST:event_ThemNVPBButtonActionPerformed

    private void XoaNVPBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaNVPBButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelNVPB = (DefaultTableModel)NhanVienPBTable.getModel();
        if(NhanVienPBTable.getSelectedRowCount()==1){
            int ind = NhanVienPBTable.getSelectedRow();
            String maNV = NhanVienPBTable.getValueAt(ind, 0).toString();
            NhanVien nv = dsNV.searchNhanVien(maNV);
            PhongBan pb = dsPB.SearchPhongBan(MaPBText.getText());
            pb.removeNhanVien(nv);
            dsPB.writeFile();
            modelNVPB.removeRow(ind);
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 nhân viên để thêm!");
        }
    }//GEN-LAST:event_XoaNVPBButtonActionPerformed

    private void HuyNVPBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HuyNVPBButtonActionPerformed
        // TODO add your handling code here:
        glassPane.setVisible(false);
        ThemNVPBPanel.setVisible(false);
    }//GEN-LAST:event_HuyNVPBButtonActionPerformed

    private void XacNhanNVPBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XacNhanNVPBButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelNVPB = (DefaultTableModel)NhanVienPBTable.getModel();
        if(NonNVPBTable.getSelectedRowCount()==1){
            int ind = NonNVPBTable.getSelectedRow();
            String maNV = NonNVPBTable.getValueAt(ind, 0).toString();
            NhanVien nv = dsNV.searchNhanVien(maNV);
            PhongBan pb = dsPB.SearchPhongBan(MaPBText.getText());
            pb.addNhanVien(nv);
            dsPB.writeFile();
            modelNVPB.addRow(nv.getData());
            glassPane.setVisible(false);
            ThemNVPBPanel.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 nhân viên để thêm!");
        }
    }//GEN-LAST:event_XacNhanNVPBButtonActionPerformed

    private void ResetNVPBButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResetNVPBButtonMouseClicked
        // TODO add your handling code here:
        ResetTableNVPB();
    }//GEN-LAST:event_ResetNVPBButtonMouseClicked

    private void BackNVPBButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackNVPBButtonMouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelDSPB = (DefaultTableModel)DSPhongBanTable.getModel();
        modelDSPB.setValueAt(dsPB.SearchPhongBan(MaPBText.getText()).getDSNhanVien().size(), DSPhongBanTable.getSelectedRow(), 3);
        glassPane.remove(ThemNVPBPanel);
        glassPane.add(ThemSuaPanel);
        ThemSuaPanel.setVisible(false);
        QuanLyPhongBan.setSelectedIndex(0);
    }//GEN-LAST:event_BackNVPBButtonMouseClicked
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        System.out.println("Hello");
//        System.out.println();
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
            java.util.logging.Logger.getLogger(AdminFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                SearchText1.setText("helloWorld");
////                new ChuyenVienFrame1().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                SearchText1.setText("helloWorld");
////                new AdminFrame1().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppName;
    private javax.swing.JLabel BackNVPBButton;
    private javax.swing.JLabel ChucNangLabel;
    private javax.swing.JLabel ChucNangLabel1;
    private javax.swing.JPanel DSDuAN;
    private javax.swing.JLabel DSNVLabel;
    private javax.swing.JLabel DSNVLabel1;
    private javax.swing.JPanel DSPhongBan;
    private javax.swing.JTable DSPhongBanTable;
    private javax.swing.JLabel DSPhongBanTitle;
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JButton HuyButton;
    private javax.swing.JButton HuyNVPBButton;
    private javax.swing.JLabel LogoutButton;
    private javax.swing.JLabel MaPBLabel;
    private javax.swing.JLabel MaPBText;
    private javax.swing.JTable NhanVienPBTable;
    private javax.swing.JTable NonNVPBTable;
    private javax.swing.JLabel PBTitle;
    private javax.swing.JPanel PhongBan;
    private javax.swing.JTabbedPane QuanLyPhongBan;
    private javax.swing.JLabel ResetButton;
    private javax.swing.JLabel ResetNVPBButton;
    private javax.swing.JButton SearchNVPBButton;
    private javax.swing.JTextField SearchNVPBText;
    private javax.swing.JButton SearchPBButton;
    private javax.swing.JTextField SearchPBText;
    private javax.swing.JPanel Sidebar;
    private javax.swing.JButton SidebarDuAn;
    private javax.swing.JButton SidebarPhongBan;
    private javax.swing.JButton SidebarTTCN;
    private javax.swing.JButton SuaButton;
    private javax.swing.JLabel SubAppName;
    private javax.swing.JPanel TTCN;
    private javax.swing.JButton TTChiTietButton;
    private javax.swing.JLabel TenPBLabel;
    private javax.swing.JLabel TenPBText;
    private javax.swing.JTextField TenPBtext;
    private javax.swing.JLabel TenTPLabel;
    private javax.swing.JButton ThemButton;
    private javax.swing.JButton ThemNVPBButton;
    private javax.swing.JPanel ThemNVPBPanel;
    private javax.swing.JLabel ThemNVPBTitle1;
    private javax.swing.JPanel ThemSuaPanel;
    private javax.swing.JLabel ThemSuaTitle;
    private javax.swing.JButton XacNhanButton;
    private javax.swing.JButton XacNhanNVPBButton;
    private javax.swing.JButton XoaButton;
    private javax.swing.JButton XoaNVPBButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
