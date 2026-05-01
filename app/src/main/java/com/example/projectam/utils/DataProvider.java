package com.example.projectam.utils;

import com.example.projectam.models.Faculty;
import com.example.projectam.models.Department;
import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<Faculty> getAllFaculties() {
        List<Faculty> faculties = new ArrayList<>();

        // ============================================================
        // FACULTY 1: Faculty of Science
        // ============================================================
        Faculty fs = new Faculty(1,
                "faculty_science",
                "كلية العلوم",
                "The Faculty of Science includes six departments: Mathematics, Physics, Chemistry, Computer Science, Biology, and Foreign Languages.",
                "تضم كلية العلوم ستة أقسام: الرياضيات، الفيزياء، الكيمياء، الإعلام الآلي، البيولوجيا، واللغات الأجنبية.",
                "Mr. ALIOUAT Mohamed",
                "+213 24 91 29 51",
                "doyenfs@umbb.dz",
                36.7667, 3.4667,
                "South Campus - Boumerdes",
                "logo_of_faculty_of_science");

        List<Department> scienceDepts = new ArrayList<>();
        scienceDepts.add(new Department(1, 1, "dept_math", "الرياضيات",
                "Department of Mathematics - Training in pure and applied mathematics",
                "قسم الرياضيات - تكوين في الرياضيات البحتة والتطبيقية",
                "Dr. Head of Mathematics Department", "+213 24 77 20 30", "math@umbb.dz",
                "Pure Mathematics, Applied Mathematics, Statistics, Modeling"));
        scienceDepts.add(new Department(2, 1, "dept_physics", "الفيزياء",
                "Department of Physics - Training in materials physics, energy and astrophysics",
                "قسم الفيزياء - تكوين في فيزياء المواد والطاقة والفيزياء الفلكية",
                "Dr. Head of Physics Department", "+213 24 32 44 50", "physics@umbb.dz",
                "Materials Physics, Energy Physics, Astrophysics"));
        scienceDepts.add(new Department(3, 1, "dept_chemistry", "الكيمياء",
                "Department of Chemistry - Training in organic, inorganic and analytical chemistry",
                "قسم الكيمياء - تكوين في الكيمياء العضوية وغير العضوية والتحليلية",
                "Dr. Head of Chemistry Department", "+213 24 10 11 88", "chemistry@umbb.dz",
                "Organic Chemistry, Inorganic Chemistry, Analytical Chemistry, Biochemistry"));
        scienceDepts.add(new Department(4, 1, "dept_computer_science", "علوم الإعلام الآلي",
                "Department of Computer Science - Training in programming, AI, networks and software engineering",
                "قسم علوم الإعلام الآلي - تكوين في البرمجة والذكاء الاصطناعي والشبكات وهندسة البرمجيات",
                "Dr. Head of Computer Science Department", "+213 24 08 22 00", "cs@umbb.dz",
                "Software Engineering, AI and Data Science, Networks and Security"));
        scienceDepts.add(new Department(5, 1, "dept_biology", "البيولوجيا",
                "Department of Biology - Training in molecular biology, ecology and biotechnology",
                "قسم البيولوجيا - تكوين في البيولوجيا الجزيئية والإيكولوجيا والتقنيات الحيوية",
                "Dr. Head of Biology Department", "+213 24 15 32 71", "biology@umbb.dz",
                "Molecular Biology, Ecology, Biotechnology, Microbiology"));
        scienceDepts.add(new Department(6, 1, "dept_languages", "اللغات الأجنبية",
                "Department of Foreign Languages - Training in English, French and applied languages",
                "قسم اللغات الأجنبية - تكوين في اللغة الإنجليزية والفرنسية واللغات التطبيقية",
                "Dr. Head of Languages Department", "+213 24 20 42 99", "languages@umbb.dz",
                "English, French, Translation, Applied Linguistics"));
        fs.setDepartments(scienceDepts);
        faculties.add(fs);

        // ============================================================
        // FACULTY 2: Faculty of Engineering Science
        // ============================================================
        Faculty fsi = new Faculty(2,
                "faculty_engineering",
                "كلية علوم الهندسة",
                "The Faculty of Engineering Science includes eight departments specialized in industrial, mechanical, civil and environmental engineering.",
                "تضم كلية علوم الهندسة ثمانية أقسام متخصصة في مجالات الهندسة الصناعية والميكانيكية والمدنية والبيئة.",
                "Mr. Messaoud El HACHEMI",
                "+213 24 91 29 51",
                "doyenfsi@umbb.dz",
                36.7600, 3.4700,
                "West Campus - Boumerdes",
                "logo_of_faculty_of_technology");

        List<Department> engDepts = new ArrayList<>();
        engDepts.add(new Department(7, 2, "dept_industrial_engineering", "هندسة العمليات الصناعية",
                "Training in design and optimization of industrial processes",
                "تكوين في تصميم وتحسين العمليات الصناعية",
                "Dr. Head of GPI Department", "+213 24 25 10 01", "gpi@umbb.dz",
                "Chemical Processes, Optimization, Industrial Simulation"));
        engDepts.add(new Department(8, 2, "dept_food_technology", "تكنولوجيا الأغذية",
                "Training in food processing and preservation",
                "تكوين في تحويل وحفظ المنتجات الغذائية",
                "Dr. Head of Food Technology Department", "+213 24 31 31 91", "foodtech@umbb.dz",
                "Dairy Industry, Cereal Technology, Quality Control"));
        engDepts.add(new Department(9, 2, "dept_environmental_engineering", "هندسة البيئة",
                "Training in environmental protection and pollution treatment",
                "تكوين في حماية البيئة ومعالجة التلوث",
                "Dr. Head of Environmental Engineering Department", "+213 24 50 62 11", "environment@umbb.dz",
                "Water Treatment, Waste Management, Air Pollution"));
        engDepts.add(new Department(10, 2, "dept_mechanical_engineering", "الهندسة الميكانيكية",
                "Training in design, manufacturing and maintenance of mechanical systems",
                "تكوين في تصميم وتصنيع وصيانة الأنظمة الميكانيكية",
                "Dr. Head of Mechanical Engineering Department", "+213 24 15 43 08", "mechanical@umbb.dz",
                "Mechanical Design, Energy, Industrial Maintenance"));
        engDepts.add(new Department(11, 2, "dept_energy", "الطاقوية",
                "Training in energy production, transport and management",
                "تكوين في إنتاج ونقل وتسير الطاقة",
                "Dr. Head of Energy Department", "+213 24 99 21 22", "energy@umbb.dz",
                "Renewable Energies, Thermodynamics, Energy Efficiency"));
        engDepts.add(new Department(12, 2, "dept_industrial_maintenance", "الصيانة الصناعية",
                "Training in maintenance management and industrial equipment reliability",
                "تكوين في تسيير الصيانة وموثوقية المعدات الصناعية",
                "Dr. Head of Industrial Maintenance Department", "+213 24 00 06 05", "maintenance@umbb.dz",
                "Preventive Maintenance, Diagnostics, Asset Management"));
        engDepts.add(new Department(13, 2, "dept_materials_engineering", "هندسة المواد",
                "Training in materials science and industrial applications",
                "تكوين في علم المواد وتطبيقاتها الصناعية",
                "Dr. Head of Materials Engineering Department", "+213 24 90 11 44", "materials@umbb.dz",
                "Metallurgy, Polymers, Composites, Ceramics"));
        engDepts.add(new Department(14, 2, "dept_civil_engineering", "الهندسة المدنية",
                "Training in infrastructure design and construction",
                "تكوين في تصميم وإنجاز البنى التحتية",
                "Dr. Head of Civil Engineering Department", "+213 24 55 80 10", "civil@umbb.dz",
                "Structures, Geotechnics, Hydraulics, Transportation"));
        fsi.setDepartments(engDepts);
        faculties.add(fsi);

        // ============================================================
        // FACULTY 3: Faculty of Hydrocarbons and Chemistry
        // ============================================================
        Faculty fhc = new Faculty(3,
                "faculty_hydrocarbons",
                "كلية الهيدروكربونات والكيمياء",
                "The Faculty of Hydrocarbons and Chemistry includes six departments specialized in oil, gas and chemical fields.",
                "تضم كلية الهيدروكربونات والكيمياء ستة أقسام متخصصة في المجال النفطي والغازي والكيميائي.",
                "Mr. Noureddine ZERAIBI",
                "+213 24 81 14 01",
                "doyen_fhc@umbb.dz",
                36.7700, 3.4600,
                "North Campus - Boumerdes",
                "logo_of_faculty_hedrocarbon");

        List<Department> hydroDepts = new ArrayList<>();
        hydroDepts.add(new Department(15, 3, "dept_geophysics", "هندسة مقاومة الزلازل والجيوفيزياء",
                "Training in seismic risk study and geophysical phenomena",
                "تكوين في دراسة المخاطر الزلزالية والظواهر الجيوفيزيائية",
                "Dr. Head of Geophysics Department", "+213 24 00 29 31 33", "geophysics@umbb.dz",
                "Seismology, Applied Geophysics, Natural Risks"));
        hydroDepts.add(new Department(16, 3, "dept_mining", "المكامن المنجمية والبترولية",
                "Training in exploration and exploitation of deposits",
                "تكوين في استكشاف واستغلال المكامن",
                "Dr. Head of Mining Department", "+213 24 22 19 00", "mining@umbb.dz",
                "Petrophysics, Drilling, Reservoir Simulation"));
        hydroDepts.add(new Department(17, 3, "dept_transport", "نقل وتجهيزات الهيدروكربورات",
                "Training in oil and gas transport and equipment",
                "تكوين في نقل وتجهيزات النفط والغاز",
                "Dr. Head of Transport Department", "+213 24 18 50 66", "transport@umbb.dz",
                "Pipeline, Storage, Industrial Safety"));
        hydroDepts.add(new Department(18, 3, "dept_chemical_process", "هندسة العمليات الكيميائية والصيدلانية",
                "Training in chemical and pharmaceutical process design",
                "تكوين في تصميم العمليات الكيميائية والصيدلانية",
                "Dr. Head of Chemical Process Department", "+213 24 18 30 21", "chemical@umbb.dz",
                "Industrial Chemistry, Pharmaceutical Chemistry, Bioprocesses"));
        hydroDepts.add(new Department(19, 3, "dept_automation", "أتمتة العمليات والكهربة",
                "Training in industrial automation and electrical systems",
                "تكوين في الأتمتة الصناعية والأنظمة الكهربائية",
                "Dr. Head of Automation Department", "+213 24 30 20 12", "automation@umbb.dz",
                "Automation, Instrumentation, Electrical Networks"));
        hydroDepts.add(new Department(20, 3, "dept_hydrocarbon_economics", "اقتصاد وتسويق المحروقات",
                "Training in oil economics and hydrocarbon marketing",
                "تكوين في اقتصاد النفط وتسويق المحروقات",
                "Dr. Head of Hydrocarbon Economics Department", "+213 24 66 73 55", "hydrocarbon-econ@umbb.dz",
                "Energy Economics, Oil Marketing, Management"));
        fhc.setDepartments(hydroDepts);
        faculties.add(fhc);

        // ============================================================
        // FACULTY 4: Faculty of Economics, Commerce and Management
        // ============================================================
        Faculty fsegc = new Faculty(4,
                "faculty_economics",
                "كلية العلوم الاقتصادية والتجارية وعلوم التسيير",
                "The faculty includes three departments: Management Sciences, Commercial Sciences, and Economic Sciences.",
                "تضم الكلية ثلاثة أقسام: علوم التسيير، العلوم التجارية، والعلوم الاقتصادية.",
                "Mr. Abderrahmane BENANTAR",
                "+213 24 81 69 26",
                "doyenfsegc@umbb.dz",
                36.7700, 3.4600,
                "North Campus - Boumerdes",
                "NULL");

        List<Department> econDepts = new ArrayList<>();
        econDepts.add(new Department(21, 4, "dept_management", "علوم التسيير",
                "Training in management, finance and human resources",
                "تكوين في التسيير، المالية والموارد البشرية",
                "Dr. Head of Management Department", "+213 24 66 31 77", "management@umbb.dz",
                "Management, Corporate Finance, HR, Audit"));
        econDepts.add(new Department(22, 4, "dept_commercial_sciences", "العلوم التجارية",
                "Training in marketing, international trade and sales",
                "تكوين في التسويق، التجارة الدولية والبيع",
                "Dr. Head of Commercial Sciences Department", "+213 24 10 20 99", "commercial@umbb.dz",
                "Marketing, International Trade, Logistics"));
        econDepts.add(new Department(23, 4, "dept_economics", "العلوم الاقتصادية",
                "Training in economics, economic policy and development",
                "تكوين في الاقتصاد، السياسة الاقتصادية والتنمية",
                "Dr. Head of Economics Department", "+213 24 21 10 44", "economics@umbb.dz",
                "Macroeconomics, Microeconomics, International Economics, Development"));
        fsegc.setDepartments(econDepts);
        faculties.add(fsegc);

        // ============================================================
        // FACULTY 5: Faculty of Law and Political Sciences
        // ============================================================
        Faculty fd = new Faculty(5,
                "faculty_law",
                "كلية الحقوق والعلوم السياسية",
                "The Faculty of Law includes three departments: Public Law, Private Law, and Political Sciences.",
                "تضم كلية الحقوق ثلاثة أقسام: الحقوق العامة، الحقوق الخاصة، والعلوم السياسية.",
                "Mr. BELGACEM Arab",
                "+213 24 91 57 72",
                "doyenfd@umbb.dz",
                36.7000, 3.4000,
                "Boudouaou Campus",
                "logo_of_faculty_of_law_and_political_sciences");

        List<Department> lawDepts = new ArrayList<>();
        lawDepts.add(new Department(24, 5, "dept_public_law", "الحقوق العامة",
                "Training in constitutional, administrative and public international law",
                "تكوين في القانون الدستوري والإداري والدولي العام",
                "Dr. Head of Public Law Department", "+213 24 33 55 91", "public-law@umbb.dz",
                "Constitutional Law, Administrative Law, Public International Law"));
        lawDepts.add(new Department(25, 5, "dept_private_law", "الحقوق الخاصة",
                "Training in civil, commercial and criminal law",
                "تكوين في القانون المدني والتجاري والجزائي",
                "Dr. Head of Private Law Department", "+213 24 20 13 14", "private-law@umbb.dz",
                "Civil Law, Business Law, Criminal Law, Procedure"));
        lawDepts.add(new Department(26, 5, "dept_political_science", "العلوم السياسية",
                "Training in political science, international relations and governance",
                "تكوين في العلوم السياسية، العلاقات الدولية والحوكمة",
                "Dr. Head of Political Science Department", "+213 24 71 32 61", "political-science@umbb.dz",
                "International Relations, Governance, Geopolitics"));
        fd.setDepartments(lawDepts);
        faculties.add(fd);

        // ============================================================
        // FACULTY 6: Faculty of Letters and Languages (NEW)
        // ============================================================
        Faculty fll = new Faculty(6,
                "faculty_letters",
                "كلية الآداب واللغات",
                "The Faculty of Letters and Languages includes three departments: Arabic Letters, French, and English.",
                "تضم كلية الآداب واللغات ثلاثة أقسام: اللغة العربية وآدابها، اللغة الفرنسية، واللغة الإنجليزية.",
                "Mr. Noureddine OULEBSIR",
                "+213 24 91 57 72",
                "n.oulebsir@univ-boumerdes.dz",
                36.7000, 3.4000,
                "Boudouaou Campus",
                "logo_of_faculty_of_letters_and_languages");

        List<Department> lettersDepts = new ArrayList<>();
        lettersDepts.add(new Department(27, 6, "dept_arabic", "اللغة العربية وآدابها",
                "Department of Arabic Letters - Training in Arabic language, literature and linguistics",
                "قسم اللغة العربية وآدابها - تكوين في اللغة العربية وآدابها واللغويات",
                "Dr. Head of Arabic Department", "+213 24 22 71 33", "arabic@umbb.dz",
                "Arabic Language, Arabic Literature, Linguistics, Criticism"));
        lettersDepts.add(new Department(28, 6, "dept_french", "اللغة الفرنسية",
                "Department of French - Training in French language, literature and civilization",
                "قسم اللغة الفرنسية - تكوين في اللغة الفرنسية وآدابها وحضارتها",
                "Dr. Head of French Department", "+213 24 99 10 21", "french@umbb.dz",
                "French Language, French Literature, Translation, Civilization"));
        lettersDepts.add(new Department(29, 6, "dept_english", "اللغة الإنجليزية",
                "Department of English - Training in English language, literature and applied linguistics",
                "قسم اللغة الإنجليزية - تكوين في اللغة الإنجليزية وآدابها واللغويات التطبيقية",
                "Dr. Head of English Department", "+213 24 55 32 44", "english@umbb.dz",
                "English Language, English Literature, Applied Linguistics, Translation"));
        fll.setDepartments(lettersDepts);
        faculties.add(fll);

        return faculties;
    }
}