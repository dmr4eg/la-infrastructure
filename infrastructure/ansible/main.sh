#!/bin/env python3
#!/bin/env false

# Init the venv
python3 -m venv .venv
source .venv/bin/activate

# Install ansible
pip3 install ansible kubernetes pyyaml
ansible-galaxy collection install kubernetes.core

# Run playbook
ansible-playbook main.yml \
  -e @group_vars/vault_azure_token.yml \
  -e @group_vars/vault_grafana_admin_password.yml \
  --ask-vault-pass --ask-become-pass

# Run playbook with tags
#ansible-playbook ansible/main.yml \
#  -e @ansible/group_vars/vault_azure_token.yml \
#  -e @ansible/group_vars/vault_grafana_admin_password.yml \
#  --ask-vault-pass --ask-become-pass \
#  --skip-tags "kind-cluster-creation,argocd-installation,monitoring"
#
