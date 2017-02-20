package ru.dzhinn.dbdatatoxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.dzhinn.dbdatatoxml.dto.item.Item;
import ru.dzhinn.dbdatatoxml.jaxb.Structure33;
import ru.dzhinn.dbdatatoxml.dto.item.licactsubtypes.LicActSubtypes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {

        log.info("Querying for customer records where first_name = 'Josh':");


        RowMapper rowMapper = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Item item = new Item();
                item.setLicenserDate(rs.getDate("lic_regdate"));
                item.setGovtName(rs.getString("irt_name"));
                item.setOrganizationOpf("");
                item.setOrganizationFullName(rs.getString("org_name"));
                item.setOrganizationName(rs.getString("org_shortname"));
                item.setOrgFirmName(rs.getString("org_shortname"));
                item.setAddrU(rs.getString("org_legaladdress"));
                item.setInn(rs.getString("org_inn"));
                item.setOgrn(rs.getString("org_regnum"));
                item.setLicActivity(rs.getString("atp_name"));
                item.setLicActSubtypes(new LicActSubtypes(rs.getString("lic_description")));
                item.setLicNum(rs.getString("lic_regnum"));
                item.setLicSD(rs.getDate("lic_regdate"));
                item.setLicED(rs.getDate("lic_expirydate"));
                item.setOrdNum(rs.getString("app_ordernum"));
                item.setOrdDate(rs.getDate("app_orderdate"));

                return item;
            }
        };
        List<Item> items = jdbcTemplate.query(
                "SELECT lic.regdate lic_regdate, irt.name irt_name, " +
                        "org.name org_name, org.shortname org_shortname, org.legaladdress org_legaladdress, " +
                        "org.regnum org_regnum, org.inn org_inn, " +
                        "atp.name atp_name, " +
                        "lic.description lic_description, " +
                        "lic.regnum lic_regnum, lic.expirydate lic_expirydate, " +
                        "app.ordernum app_ordernum, app.orderdate app_orderdate " +
                        "FROM licences lic, inspectorates irt, applications app, organizations org, ATY_TYPES atp  " +
                        "WHERE lic.app_id=app.id and app.irt_id_reg=irt.id and app.org_id_lic=org.id " +
                        "and app.atp_id=atp.id " +
                        "and lic.status = ?",
                new Object[] { "1" },
                rowMapper
        );

        Structure33.createXML(items);
    }
}
