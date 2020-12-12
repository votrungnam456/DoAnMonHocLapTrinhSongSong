package com.longnguyen.service;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import com.longnguyen.algorithm.QuickSortSingle;
import com.longnguyen.algorithm.QuickSortThreaded;
import com.longnguyen.algorithm.searchThreaded;
import com.longnguyen.model.SachModel;


public class SachService {
	public double getTimeSingle() {
		return timeSingle;
	}

	public void setTimeSingle(double timeSingle) {
		this.timeSingle = timeSingle;
	}

	public double getTimeThreads() {
		return timeThreads;
	}

	public void setTimeThreads(double timeThreads) {
		this.timeThreads = timeThreads;
	}

	public Long getSizeArray() {
		return sizeArray;
	}

	public void setSizeArray(Long sizeArray) {
		this.sizeArray = sizeArray;
	}

	public Long getNumberThreads() {
		return numberThreads;
	}

	public void setNumberThreads(Long numberThreads) {
		this.numberThreads = numberThreads;
	}

	private double timeSingle, timeThreads;
	private Long sizeArray, numberThreads;
	private String[] hos = { "Nguyễn ", "Lê ", "Ngô ", "Trần ", "Phạm ", "Huỳnh ", "Đỗ ", "Bùi ", "Ngô ", "Dương ",
							"Lý ", "Đặng ", "Hồ ", "Phan ", "Cao ", "Võ ", "Kim ", "Liễu ", "Đoàn ", "Đàm ", 
							"Thái ", "Trịnh ", "Lưu ", "Hoàng ", "Trương ", "Vương ", "Chu ", "Triệu ", "Tạ ", "Tiêu ",
							"Hạ ", "Ông","Quách"};
	private String[] tenLots = { "Thành ", "Trung ", "Quang ", "Phương ", "Bảo ", "Vân ", "An ","Anh ","Gia ","Phụng ","Thị ","Trần ","Thị Ngọc ","Thế " };
	private String[] tens = { "Long", "Duy", "Sơn", "Nam", "Xuân", "Quỳnh", "Tài", "Lân","Khang","Khánh","Ý"};

	private String[] tenSachs = { "Người xa lạ", "Đi tìm thời gian đã mất", "Hoàng tử bé", "Chùm nho uất hận"
			,"Trên đường băng","Cafe cùng Tony","Nơi em trở về có tôi đứng đợi","Đắc nhân tâm",
			"Trái đất tròn không gì là không thể","Ai sẽ mang giày cao gót cho em","Tôi thấy hoa vàng trên cỏ xanh",
			"Kính vạn hoa","Hành trình của Elaina", "Color full"};

	private String[] moTas = { "Qua Người xa lạ, Camus đã tạo nên một nhân vật Meursault hoàn toàn xa lạ với chính mình, với thế giới, với cái chết, với tình yêu và với mọi mối quan hệ xã hội. Trong sự vô nghĩa của đời sống con người, trên con đường đến với cái chết treo lơ lửng, Meursault đã đi qua Vô thức, Tỉnh thức và cuối cùng là Nổi loạn (Phản kháng)."
			, "Chỉ có những sợ thích cá nhân của mỗi người mới thực tồn và không thể chối cãi", "Người lớn chẳng bao giờ tự hiểu được cái gì cả, và thật mệt cho trẻ con khi cứ phải giải thích cho họ", "Giữ thời kỳ vàng son của xã hội công nghiệp, nhà Joad của như bao gia đình khách bỗng nhiên bị đuổi ra khỏi nơi..."
			,"Cứ mãi ở ao làng, rồi ao sẽ cạn. Sao không ra sông ra biễn để vẫy vùng? Sao tự trói mình trong nếp nghĩ bùng nhùng?....","Ăn và nói đi cung với nhau, nên người ta hay bảo:'Thằng đó biêt ăn biết nói', hay 'Con bé đó ăn nói khôn khéo, vừa khôn vừa khéo'...","Cuộc đời vốn là những chuỗi hội ngộ và chia ly. Hội ngội là để chia ly. Chia ly là để hội ngộ",
			"Tác phẩm có sức loan tỏa vô cùng lớn - dù bạn đi đến bất cứ đâu, bất kỳ quốc gia nào cũng đều có thể nhìn thấy...",
			"Trái Đất Tròn Không Gì Là Không Thể là tuyển tập truyện ngắn đậm chất Ploy. Nội dung hấp dẫn. Cách dụng ngôn ngữ tài tình và độc đáo. Những phép miêu tả lạ lùng, thú vị... dẫn dắt, lôi kéo người đọc vào một thế giới rất Ploy.",
			"Ai đã từng đọc truyện cổ tích Nàng Lọ Lem sẽ không thể quên được chiếc giày thủy tinh nàng đánh rơi khi chạy trốn hoàng tử trong đêm vũ hội. Và chính chiếc giày đó mang Lọ Lem trở về với người mình yêu thương. Cổ tích là vậy, nhưng với “Ai sẽ mang giày cao gót cho em?” nàng “Lọ Lem” lại là một cô gái không chịu yên phận...",
			"Ta bắt gặp trong Tôi Thấy Hoa Vàng Trên Cỏ Xanh một thế giới đấy bất ngờ và thi vị non trẻ với những suy ngẫm giản dị thôi nhưng gần gũi đến lạ. Câu chuyện của Tôi Thấy Hoa Vàng Trên Cỏ Xanh có chút này chút kia, để ai soi vào cũng thấy mình trong đó, kiểu như lá thư tình đầu đời của cu Thiều chẳng hạ ngây ngô và khờ khạo.",
			"Kính Vạn Hoa là tác phẩm công phu nhất trong sự nghiệp của nhà văn Nguyễn Nhật Ánh, được trẻ em Việt Nam nhiều thế hệ yêu thích và đón nhận nồng nhiệt. Những câu chuyện thú vị xoay quanh cuộc sống của nhóm bạn Tiểu Long, Quý Ròm, Nhỏ Hạnh… cùng những chuyến phiêu lưu kì thú, bất ngờ, kì lạ… đã đưa các em bước vào một thế giới “cổ tích hiện đại”, có thực và tràn ngập ánh sáng yêu thương. Bộ sách đã thể hiện tình yêu, trách nhiệm và tâm huyết của tác giả đối với thế hệ trẻ. Nguyễn Nhật Ánh đã “thâm nhập” vào thế giới tâm hồn của tuổi thơ để hiểu và đồng cảm với những cảm xúc, suy tư của các em trước cuộc sống. “Kính Vạn Hoa” đã thực sự phản ánh toàn diện, đề cập tới tất cả các khía cạnh trong đời sống tâm hồn của trẻ em và đặc biệt là trách nhiệm xã hội của nhà văn đối với việc hoàn thiện nhân cách của các em.",
			"Ở xứ sở xa xôi, có một cô phù thủy tên Elaina. Nhờ ảnh hưởng sau khi đọc 'cuốn sách nọ' từ thuở nhỏ, cô đang thực hiện chuyến du hành thật dài.",
			"Có một người phạm tội nặng, chết đi không được luân hồi. Nhưng trong lúc linh hồn người này đang mất trí nhớ và trôi nổi vô định về một nơi tối tăm xứng đáng với cậu ta, thì một thiên sứ cánh trắng xuất hiện, giơ tay chặn lại, thông báo rằng cậu vừa trúng phiên xổ số may mắn của thiên đình, nhận được cơ hội tu hành kiêm tái thử thách."};

	public List<SachModel> listSingle = new ArrayList<>();
	public List<SachModel> listThreads = new ArrayList<>();

	public void getListSach(int number) throws ParseException {
		for (int i = 0; i < number; i++) {
			int ho = 0 + (int) (Math.random() * hos.length);
			int tenLot = 0 + (int) (Math.random() * tenLots.length);
			int ten = 0 + (int) (Math.random() * tens.length);
			int sach = 0 + (int) (Math.random() * tenSachs.length);
			int soNgayMuon = 1 + (int) (Math.random() * 30);
			int ngay = 1 + (int) (Math.random() * 30);
			int thang = 1 + (int) (Math.random() * 12);
			int nam = 2019 + (int) (Math.random() * 2);
			String ngayMuon = ngay + "/" + thang + "/" + nam;
			SachModel model = new SachModel();

			String moTa = "";
			moTa = moTas[sach];
			String hoVaTen = "";
			hoVaTen = hos[ho];
			hoVaTen += tenLots[tenLot];
			hoVaTen += tens[ten];

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = sdf.parse(ngayMuon);

			model.setTenNguoiMuon(hoVaTen);
			model.setTenSach(tenSachs[sach]);
			model.setMaPhieuMuon("MPM" + i);
			model.setNgayMuon(date1);
			model.setNgayMuonStr(ngayMuon);
			model.setMoTa(moTa);

			listSingle.add(model);
			listThreads.add(model);
		}
	}

	public double SortSingle(List<SachModel> myList, String styleSort) {
		QuickSortSingle sort = new QuickSortSingle();
		double start = System.nanoTime()/1000000;
		sort.sort(myList, styleSort);
		double end = (System.nanoTime()/1000000) - start;
		System.out.println("Single array sorted in " + end + " ms");
		return end;
	}
	
	public double SortThreaded(int numberThreads,List<SachModel> myList, String styleSort) {
		QuickSortThreaded sort = new QuickSortThreaded();
		sort.a = myList;
		double time = 0l;
		try {
			time = sort.QuickSortThread(numberThreads, styleSort);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Threads array sorted in " + time + " ms");
		return time;
	}

	public List<SachModel> search(String item, List<SachModel> myArray, String styleSearch){
		searchThreaded search = new searchThreaded(myArray, 8,item, styleSearch);
		search.init_Thread();
		search.Start_Thread();

		return search.searchArray;
	}
}
