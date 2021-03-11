import org.springframework.cloud.contract.spec.Contract
Contract.make{
	request{
		method 'GET'
		urlPath('/hotels/api/v1/hotelDetails/1')
		headers {
			contentType(applicationJson())
		}
	}
	response{
		status OK()
		body(
		"hotel_Id":1,
		"name":"AMB",
		"description":"near ASP",
		"rating":"4.5"
		)
		headers {
			contentType(applicationJson())
		}
	}
}