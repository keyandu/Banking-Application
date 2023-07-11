export const environment = {
    production:false,
    staffLoginUrl:'http://localhost:8085/api/staff/authenticate',
    getCustomerStatement:'http://localhost:8085/api/staff/customer/getAccountStatmentById',
    listAccountToBeApproved:'http://localhost:8085/api/staff/customer/getAllAccountToBeApproved',
    approveAccount:'http://localhost:8085/api/staff/customer/approveAccountOrNot',
    listAllCustomer:'http://localhost:8085/api/staff/customer/listAllCustomer',
    EnableOrDisableCustomer:'http://localhost:8085/api/staff/customer/changeCustomerStatus',
    listBanToBeApproved:'http://localhost:8085/api/staff/customer/listBeneficiaryToBeApproved',
    approveban:'http://localhost:8085/api/staff/customer/approveBeneficiaryOrNot',
    listAllAccount:'http://localhost:8085/api/staff/customer/dispalyAllAccount'
};