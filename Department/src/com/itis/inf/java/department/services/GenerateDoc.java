package com.itis.inf.java.department.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itis.inf.java.department.dao.companyDao.CompanyDao;
import com.itis.inf.java.department.dao.models.Company;
import com.itis.inf.java.department.dao.models.Doc;
import com.itis.inf.java.department.dao.models.User;
import com.itis.inf.java.department.dao.userDao.UserDao;
import com.itis.inf.java.department.dao.userDao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@Component
public class GenerateDoc {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    @Autowired
    UserDao userDao;

    @Autowired
    CompanyDao companyDao;

    public String justDoIt(Doc doc) throws DocumentException, IOException {
        logger.info("find user with " + doc.getUserID() + " id");
        User user = userDao.getUser(doc.getUserID());
        logger.info("find company with " + user.getCompany());
        Company company = companyDao.getCompany(user.getCompany());
        Random num = new Random();
        String CATALINA_HOME = "/home/rumia/Downloads/";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(CATALINA_HOME + user.getSurname() +".pdf"));
        document.open();

        document.add(new Paragraph(
                "     СОГЛАСОВАНО                             УТВЕРЖДАЮ\n" +
                "\n" +
                "Железнодорожная администрация              Руководитель\n" +
                "\n" +
                "                                       организации-исполнителя\n" +
                "\n" +
                "М.П.                                                   М.П.\n" +
                "\n" +
                doc.getRailwayAdmin() + "                   " + company.getAdmin() + "\n" +
                "\n" +
                new Date() + "                              " + new Date() + "\n" +
                "\n" +
                "ТЕХНИЧЕСКОЕ РЕШЕНИЕ N " + num.nextInt() + "\n" +
                "\n" +
                "о продлении срока службы подвижного состава, принадлежащего\n" +
                "\n" +
                company.getName() + " " + user.getName() + "\n" +
                "\n" +
                "(полное наименование предприятия - собственника вагонов)\n" +
                "\n" +
                "и приписанного к станции " + doc.getTrainStation() + ", " + doc.getTrainDepot() + ", "
                        + doc.getTrainRailRoad() + "\n" +
                "\n" +
                "(указать станцию, депо, железную дорогу)\n" +
                "\n" +
                doc.getRailwayName() + "\n" +
                "\n" +
                "(полное наименование специализированной организации - исполнителя)\n" +
                "\n" +
                "на основании обследования технического состояния, технического\n" +
                "\n" +
                "диагностирования и результатов проведенных испытаний назначается\n" +
                "\n" +
                "вид и объем необходимых ремонтных работ и после их выполнения\n" +
                "\n" +
                "продлевается срок службы следующему подвижному составу (____ ед.):"));

        PdfPTable table = new PdfPTable(9);
        table.addCell("№ п/п");
        table.addCell("№ вагона");
        table.addCell("Модель п/с");
        table.addCell("Вид назначенного ремонта");
        table.addCell("Дата посторойки");
        table.addCell("Вид назначенного ремонта");
        table.addCell("Номер проектов, ТУ, руководства");
        table.addCell("Срок службы продлён до");
        table.addCell("Род перевозимого груза");
        table.addCell("Дата проведения ремонта");

        table.addCell("1");
        table.addCell("1");
        table.addCell(doc.getTrainModel());
        table.addCell(doc.getTrainStartDate());
        table.addCell(doc.getTrainRepairType());
        table.addCell("1");
        table.addCell(doc.getTrainEndDate());
        table.addCell(doc.getTrainContentType());
        table.addCell(doc.getTrainRepairDate());

        document.add(table);

        document.add(new Paragraph("" +
                "Срок службы сменных деталей и узлов подвижного состава по\n" +
                "\n" +
                "данному техническому решению продлению не подлежит.\n" +
                "\n" +
                "Приложение.\n" +
                "\n" +
                "Отчет об обследовании технического состояния и техническом\n" +
                "\n" +
                "диагностировании.\n" +
                "\n" +
                doc.getRailwayAdmin() + "\n" +
                "\n" +
                "(ответственный исполнитель)\n" +
                "\n" +
                "                                               М.П.\n" +
                "\n" +
                "                                              "  + new Date()));

        document.close();
        return CATALINA_HOME + user.getSurname() + ".pdf";
    }
}