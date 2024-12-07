

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Service
public class DepartmentService {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean updateDepartment(int departmentId, String newName, String newLocation) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE Department SET name = :name, location = :location WHERE departmentId = :id";
        Query query = session.createQuery(hql);
        query.setParameter("name", newName);
        query.setParameter("location", newLocation);
        query.setParameter("id", departmentId);

        int result = query.executeUpdate();
        transaction.commit();
        session.close();

        return result > 0;
    }
}
